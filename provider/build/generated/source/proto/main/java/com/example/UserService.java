package com.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

public interface UserService {

    static final String JAVA_SERVICE_NAME = "com.example.UserService";
    static final String SERVICE_NAME = "api.UserService";

    // FIXME, initialize Dubbo3 stub when interface loaded, thinking of new ways doing this.
    static final boolean inited = UserServiceDubbo.init();

    com.example.User getUser(com.example.UserRequest request);

    default CompletableFuture<com.example.User> getUserAsync(com.example.UserRequest request){
        return CompletableFuture.supplyAsync(() -> getUser(request));
    }




}
