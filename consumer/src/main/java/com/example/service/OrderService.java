package com.example.service;

import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboReference;
import com.example.domain.User;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @DubboReference(version = "2.0", interfaceClass = UserService.class, check = false)
    private UserService userService;

    public String createOrder(){
        // unary
//        User user = userService.getUser("1");
//        System.out.println("创建订单");
//        return user.toString() + " succeeded in creating the order";

        // SERVER_STREAM
//        userService.sayHelloServerStream("hello", new StreamObserver<String>() {
//            public void onNext(String data) {
//                System.out.println("接收到结果：" + data);
//            }
//
//            public void onError(Throwable throwable) {
//
//            }
//
//            public void onCompleted() {
//                System.out.println("结束");
//            }
//        });

        StreamObserver<String> streamObserver = userService.sayHelloStream(new StreamObserver<String>() {
            public void onNext(String data) {
                System.out.println("接收到的结果：" + data);
            }

            public void onError(Throwable throwable) {

            }

            public void onCompleted() {
                System.out.println("发送完成");
            }
        });

        streamObserver.onNext("1");
        streamObserver.onNext("2");
        streamObserver.onNext("3");
        streamObserver.onCompleted();
        return "success";
    }
}
