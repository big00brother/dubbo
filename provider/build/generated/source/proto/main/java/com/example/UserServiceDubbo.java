    package com.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

public final class UserServiceDubbo {
private static final AtomicBoolean registered = new AtomicBoolean();

public static boolean init() {
    if (registered.compareAndSet(false, true)) {
            org.apache.dubbo.rpc.protocol.tri.SingleProtobufUtils.marshaller(
            com.example.User.getDefaultInstance());
            org.apache.dubbo.rpc.protocol.tri.SingleProtobufUtils.marshaller(
            com.example.UserRequest.getDefaultInstance());
    }
    return true;
}

private UserServiceDubbo() {}

}
