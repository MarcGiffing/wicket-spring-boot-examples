package com.giffing.examples.wicket.spring.boot.simple;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WicketApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder()
			.sources(WicketApplication.class)
			.run(args);
	}

}
