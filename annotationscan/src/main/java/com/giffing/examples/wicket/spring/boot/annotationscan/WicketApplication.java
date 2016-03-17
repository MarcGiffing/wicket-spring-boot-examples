package com.giffing.examples.wicket.spring.boot.annotationscan;

import org.apache.wicket.Page;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.giffing.examples.wicket.spring.boot.annotationscan.pages.HomePage;
import com.giffing.wicket.spring.boot.starter.app.WicketBootWebApplication;
import com.giffing.wicket.spring.boot.starter.context.WicketSpringBootApplication;

@WicketSpringBootApplication
public class WicketApplication extends WicketBootWebApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder().sources(WicketApplication.class).run(args);
	}
	
	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

}
