package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yswu
 * @date 2021-02-25 21:30
 */

@RestController
public class SendMessageController {
    private  final IMessageProvider messageProvider;

    public SendMessageController(IMessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }


    @GetMapping(value = "/sendMessage")
    public String sendMessage(){

      return messageProvider.send();
    }
}
