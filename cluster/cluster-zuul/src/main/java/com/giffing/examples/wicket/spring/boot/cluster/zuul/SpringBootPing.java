package com.giffing.examples.wicket.spring.boot.cluster.zuul;

import org.springframework.stereotype.Component;

import com.netflix.loadbalancer.PingUrl;

@Component
public class SpringBootPing  extends PingUrl {
    @Override
    public String getPingAppendString() {
        return "/health";
    }
}