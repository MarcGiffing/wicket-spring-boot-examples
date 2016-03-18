package com.giffing.examples.wicket.spring.boot.bootstrap;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.giffing.examples.wicket.spring.boot.bootstrap.pages.BasePage;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;

@WicketHomePage
public class HomePage extends BasePage {

	public HomePage(PageParameters parameters) {
		super(parameters);
		
	}

}
