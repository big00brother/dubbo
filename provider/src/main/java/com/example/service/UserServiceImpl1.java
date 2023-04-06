package com.example.service;

import com.example.User;
import com.example.UserRequest;
import com.example.UserService;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.concurrent.CompletableFuture;

@DubboService(interfaceClass = UserService.class, version = "1.0")
public class UserServiceImpl1 implements UserService {

    @Override
    public User getUser(UserRequest request) {
        User user = User.newBuilder().setUid(request.getUid()).setUsername("zhangsan").build();
        return user;
    }

    @Override
    public CompletableFuture<User> getUserAsync(UserRequest request) {
        return UserService.super.getUserAsync(request);
    }

    // SERVER_STREAM
//    public void sayHelloServerStream(String name, StreamObserver<String>
//            response) {
//        response.onNext(name + " hello");
//        response.onNext(name + " world");
//        response.onCompleted();
//    }
//
//    // CLIENT_STREAM
//    public StreamObserver<String> sayHelloStream(final StreamObserver<String> response) {
//        return new StreamObserver<String>() {
//            public void onNext(String data) {
//                System.out.println("服务端接收到的数据：" + data);
//
//                //处理data
//
//                response.onNext("响应结果：" + data);
//            }
//
//            public void onError(Throwable throwable) {
//
//            }
//
//            public void onCompleted() {
//                System.out.println("发送完成");
//            }
//        };
//    }
}
