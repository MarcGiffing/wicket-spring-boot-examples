package com.giffing.examples.wicket.spring.boot.springsecurity;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import com.giffing.wicket.spring.boot.starter.context.WicketSpringBootApplication;

@WicketSpringBootApplication
public class WicketApplication extends WicketBootSecuredWebApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder().sources(WicketApplication.class).run(args);
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return LoginPage.class;
	}

}
