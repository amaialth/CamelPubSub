package com.anbu.pubsub;

import jakarta.annotation.PostConstruct;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Router extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("google-pubsub://dogwood-actor-327302:YTDEMO-sub")
                .log("Message Received : ${body}")
                .process(exchange -> {
                    String message = exchange.getIn().getBody(String.class);
                    System.out.println("Processing message: "+message);
                });
        from("direct:postMessage")
                .to("google-pubsub://dogwood-actor-327302:YTDEMO");
    }
}
