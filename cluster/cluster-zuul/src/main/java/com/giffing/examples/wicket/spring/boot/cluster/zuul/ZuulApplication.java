package com.giffing.examples.wicket.spring.boot.cluster.zuul;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder()
			.sources(ZuulApplication.class)
			.run(args);
	}
	
	
}
