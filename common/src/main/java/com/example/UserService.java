package com.example;

import java.util.concurrent.CompletableFuture;

public interface UserService {

    static final String JAVA_SERVICE_NAME = "com.example.UserService";
    static final String SERVICE_NAME = "api.UserService";

    // FIXME, initialize Dubbo3 stub when interface loaded, thinking of new ways doing this.
    static final boolean inited = UserServiceDubbo.init();

    User getUser(UserRequest request);

    default CompletableFuture<User> getUserAsync(UserRequest request){
        return CompletableFuture.supplyAsync(() -> getUser(request));
    }




}
