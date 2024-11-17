package com.anbu.pubsub;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostMessageContoller {
    @Autowired
    ProducerTemplate producerTemplate;
    @GetMapping("/postMessage")
    public void postMessage(){
        producerTemplate.sendBody("direct:postMessage","Message ffrom API calll");
    }
}
