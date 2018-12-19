package com.sum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qinxz on 2018/12/18.
 */
@RestController
public class HelloController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    private PortDemo portDemo;

    @RequestMapping("/hello")
    public String hello() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        //打印服务的服务id
        return "hello,my service id：" + instance.getServiceId() + "，port：" + portDemo.getPort();
    }

}


