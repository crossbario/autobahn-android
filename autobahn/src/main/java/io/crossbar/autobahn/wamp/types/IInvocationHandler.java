package io.crossbar.autobahn.wamp.types;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface IInvocationHandler<R> {
    R run(List<Object> args, Map<String, Object> kwargs);
}
