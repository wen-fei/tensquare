package com.tensquare.sms.listener;

import com.aliyuncs.exceptions.ClientException;
import com.tensquare.sms.util.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author : TenYun
 * @date : 2019-06-07 16:22
 * @description :
 **/
@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    // 模板编号
    @Value("${aliyun.sms.template_code}")
    private String template_code;

    // 签名
    @Value("${aliyun.sms.sign_name}")
    private String sign_name;

    @RabbitHandler
    public void sendSms(Map<String, String> message) {
        System.out.println("手机号: " + message.get("mobile"));
        System.out.println("验证码: " + message.get("code"));

        try {
            smsUtil.sendSms(message.get("mobile"), template_code, sign_name,
                    "{\"number\":\"" + message.get("code") + "\"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
