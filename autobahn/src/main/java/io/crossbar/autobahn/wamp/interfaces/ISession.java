///////////////////////////////////////////////////////////////////////////////
//
//   AutobahnJava - http://crossbar.io/autobahn
//
//   Copyright (c) Crossbar.io Technologies GmbH and contributors
//
//   Licensed under the MIT License.
//   http://www.opensource.org/licenses/mit-license.php
//
///////////////////////////////////////////////////////////////////////////////

package io.crossbar.autobahn.wamp.interfaces;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import io.crossbar.autobahn.wamp.Session;
import io.crossbar.autobahn.wamp.types.CallOptions;
import io.crossbar.autobahn.wamp.types.CallResult;
import io.crossbar.autobahn.wamp.types.CloseDetails;
import io.crossbar.autobahn.wamp.types.IEventHandler;
import io.crossbar.autobahn.wamp.types.IInvocationHandler;
import io.crossbar.autobahn.wamp.types.Publication;
import io.crossbar.autobahn.wamp.types.PublishOptions;
import io.crossbar.autobahn.wamp.types.RegisterOptions;
import io.crossbar.autobahn.wamp.types.Registration;
import io.crossbar.autobahn.wamp.types.SessionDetails;
import io.crossbar.autobahn.wamp.types.SubscribeOptions;
import io.crossbar.autobahn.wamp.types.Subscription;

public interface ISession {

    CompletableFuture<Subscription> subscribe(String topic, IEventHandler handler, SubscribeOptions options);

    CompletableFuture<Publication> publish(String topic,
                                           List<Object> args,
                                           Map<String, Object> kwargs,
                                           PublishOptions options);

    CompletableFuture<Registration> register(String procedure, IInvocationHandler endpoint, RegisterOptions options);

    CompletableFuture<CallResult> call(String procedure,
                                       List<Object> args,
                                       Map<String, Object> kwargs,
                                       CallOptions options);

    <T> CompletableFuture<T> call(String procedure,
                                  List<Object> args,
                                  Map<String, Object> kwargs,
                                  TypeReference<T> resultType,
                                  CallOptions options);
/*
    <T> CompletableFuture<T> call(String procedure,
                                  TypeReference<T> resultType,
                                  CallOptions options,
                                  Object... args);
*/
    CompletableFuture<SessionDetails> join(String realm, List<String> authMethods);

    void leave(String reason, String message);

    boolean isConnected();

    interface OnJoinListener {
        void onJoin(Session session, SessionDetails details);
    }

    interface OnReadyListener {
        void onReady(Session session);
    }

    interface OnLeaveListener {
        void onLeave(Session session, CloseDetails details);
    }

    interface OnConnectListener {
        void onConnect(Session session);
    }

    interface OnDisconnectListener {
        void onDisconnect(Session session, boolean wasClean);
    }

    // FIXME: come up with an equivalent of txaio.IFailedFuture as first arg.
    interface OnUserErrorListener {
        void onUserError(Session session, String message);
    }
}
