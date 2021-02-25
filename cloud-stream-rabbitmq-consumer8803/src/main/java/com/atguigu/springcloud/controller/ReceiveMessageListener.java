package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yswu
 * @date 2021-02-25 21:51
 */

@RestController
@EnableBinding({Sink.class})
public class ReceiveMessageListener {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){

        System.out.println("消费者2号，---- 》接到的消息："+message.getPayload()+"\t port" + serverPort);


    }}
