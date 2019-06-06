package com.tensquare.user;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : TenYun
 * @date : 2019-06-06 21:39
 * @description :
 **/
@Component
@RabbitListener(queues = {"itcast"})
public class Customer1 {

    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("itcast接收消息:" + message);
    }
}
