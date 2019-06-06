package com.tensquare.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : TenYun
 * @date : 2019-06-06 21:35
 * @description :
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class MqTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSend() {
        rabbitTemplate.convertAndSend("itcast", "我要红包");
    }
}
