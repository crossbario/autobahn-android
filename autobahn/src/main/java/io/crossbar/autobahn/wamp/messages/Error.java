package io.crossbar.autobahn.wamp.messages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.crossbar.autobahn.wamp.exceptions.ProtocolError;
import io.crossbar.autobahn.wamp.interfaces.IMessage;

public class Error implements IMessage {

    public static final int MESSAGE_TYPE = 8;

    public final int requestType;
    public final long request;
    public final String error;
    public final List<Object> args;
    public final Map<String, Object> kwargs;

    public Error(int requestType, long request, String error, List<Object> args, Map<String, Object> kwargs) {
        this.requestType = requestType;
        this.request = request;
        this.error = error;
        this.args = args;
        this.kwargs = kwargs;
    }

    public static Error parse(List<Object> wmsg) {
        if (wmsg.size() == 0 || !(wmsg.get(0) instanceof Integer) || (int) wmsg.get(0) != MESSAGE_TYPE) {
            throw new IllegalArgumentException("Invalid message.");
        }

        if (wmsg.size() < 5 || wmsg.size() > 7) {
            throw new ProtocolError(String.format("invalid message length %s for ERROR", wmsg.size()));
        }

        int requestType = (int) wmsg.get(1);
        // FIXME: add validation here. see:
        // https://github.com/crossbario/autobahn-python/blob/886973ca139916176d5db707ffc7fa20f9529010/autobahn/wamp/message.py#L1291
        long request = (long) wmsg.get(2);
        Map<String, Object> details = (Map<String, Object>) wmsg.get(3);
        String error = (String) wmsg.get(4);

        if (wmsg.size() == 6 && wmsg.get(5) instanceof byte[]) {
            throw new ProtocolError("Binary payload not supported");
        }

        List<Object> args = null;
        if (wmsg.size() > 5) {
            args = (List<Object>) wmsg.get(5);
        }

        Map<String, Object> kwargs = null;
        if (wmsg.size() > 6) {
            kwargs = (Map<String, Object>) wmsg.get(6);
        }

        return new Error(requestType, request, error, args, kwargs);
    }

    @Override
    public List<Object> marshal() {
        List<Object> marshaled = new ArrayList<>();
        marshaled.add(MESSAGE_TYPE);
        marshaled.add(requestType);
        marshaled.add(request);
        marshaled.add(new HashMap<String, Object>());
        marshaled.add(error);
        if (args != null) {
            marshaled.add(args);
        }
        if (kwargs != null) {
            marshaled.add(kwargs);
        }
        return marshaled;
    }
}
