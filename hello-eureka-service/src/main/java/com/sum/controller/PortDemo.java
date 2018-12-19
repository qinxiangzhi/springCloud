package com.sum.controller;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by qinxz on 2018/12/19.
 */
@Component
public class PortDemo implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

    private int serverPort;

    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
        this.serverPort = event.getEmbeddedServletContainer().getPort();

    }

    public int getPort() {
        return this.serverPort;
    }

}