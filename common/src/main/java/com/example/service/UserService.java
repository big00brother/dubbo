package com.example.service;

import com.example.domain.User;
import org.apache.dubbo.common.stream.StreamObserver;

public interface UserService {
    // UNARY
    User getUser(String uid);

    // SERVER_STREAM
    void sayHelloServerStream(String name, StreamObserver<String> response);

    // CLIENT_STREAM
    StreamObserver<String> sayHelloStream(StreamObserver<String> response);
}
