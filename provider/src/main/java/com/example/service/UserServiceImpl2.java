package com.example.service;

import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;
//import com.example.domain.User;

//@DubboService(interfaceClass = UserService.class, version = "2.0")
public class UserServiceImpl2 {

//    public User getUser(String uid) {
//        User user = new User(uid, "lisi");
//        return user;
//    }

    // SERVER_STREAM
    public void sayHelloServerStream(String name, StreamObserver<String>
            response) {
        response.onNext(name + " hello");
        response.onNext(name + " world");
        response.onCompleted();
    }

    // CLIENT_STREAM
    public StreamObserver<String> sayHelloStream(final StreamObserver<String> response) {
        return new StreamObserver<String>() {
            public void onNext(String data) {
                System.out.println("服务端接收到的数据：" + data);

                //处理data

                response.onNext("响应结果：" + data);
            }

            public void onError(Throwable throwable) {

            }

            public void onCompleted() {
                System.out.println("发送完成");
            }
        };
    }
}
