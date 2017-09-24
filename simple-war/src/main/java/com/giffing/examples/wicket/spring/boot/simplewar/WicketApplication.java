package com.giffing.examples.wicket.spring.boot.simplewar;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class WicketApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder()
			.sources(WicketApplication.class)
			.run(args);
	}

}
