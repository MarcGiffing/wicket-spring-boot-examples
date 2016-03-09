package com.giffing.examples.wicket.spring.boot.internaltest.app;


import org.apache.wicket.Page;
import org.springframework.stereotype.Component;

import com.giffing.examples.wicket.spring.boot.internaltest.pages.HomePage;
import com.giffing.wicket.spring.boot.starter.app.WicketBootWebApplication;

@Component("wicketBootWebApplication")
public class WicketWebApplication extends WicketBootWebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

}
