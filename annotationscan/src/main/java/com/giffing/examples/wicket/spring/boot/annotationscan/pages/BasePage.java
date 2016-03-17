package com.giffing.examples.wicket.spring.boot.annotationscan.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class BasePage extends WebPage {
	
	public BasePage() {
		add(new BookmarkablePageLink<Void>("home", HomePage.class));
		add(new BookmarkablePageLink<Void>("first", FirstPage.class));
		add(new BookmarkablePageLink<Void>("second", SecondPage.class));
	}
	
}
