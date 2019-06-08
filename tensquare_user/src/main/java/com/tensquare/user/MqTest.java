package com.tensquare.user;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

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

    @Test
    public void testSendFanout() {
        rabbitTemplate.convertAndSend("chuanzhi", "", "分列模式测试");
    }


    @Test
    public void testSendTopic1() {
        rabbitTemplate.convertAndSend("topictest", "goods.aaa", "主题模式");
    }

    @Test
    public void testSendTopic2() {
        rabbitTemplate.convertAndSend("topictest", "article.content.log", "主题模式");
    }

    @Test
    public void testSendTopic3() {
        rabbitTemplate.convertAndSend("topictest", "goods.log", "主题模式");
    }

    @Test
    public void jwtTest() {
        JwtBuilder builder = Jwts.builder().setId("888")
                .setSubject("小白")
                // 设置签发时间
                .setIssuedAt(new Date())
                // 设置签名密匙，每次运行不一样，因为载荷中包含了时间
                .signWith(SignatureAlgorithm.HS256, "itcast");

        System.out.println(builder.compact());
    }

    @Test
    public void jwtTest2() {
        long now = System.currentTimeMillis();
        // 过期时间1分钟
        long exp = now + 1000*60;
        JwtBuilder builder = Jwts.builder().setId("888")
                .setSubject("小白")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "itcast")
                .setExpiration(new Date(exp));
        System.out.println(builder.compact());
    }
}
