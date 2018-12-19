package com.sum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by qinxz on 2018/12/18.
 */
@RestController
public class HolleConsumerController {

    //这里注入的restTemplate就是在com.sam.ConsumerApp中通过@Bean配置的实例
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hello-consumer")
    public String helloConsumer() {
        //调用hello-service服务，注意这里用的是服务名，而不是具体的ip+port
        Object result = restTemplate.getForObject("http://hello-eureka-service/hello", String.class);
        System.out.println("-----------------返回结果为：" + result);
        return "hello consumer finish !!!";
    }
}
