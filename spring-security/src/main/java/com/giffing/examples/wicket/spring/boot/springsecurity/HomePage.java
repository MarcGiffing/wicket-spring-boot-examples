package com.giffing.examples.wicket.spring.boot.springsecurity;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;

@WicketHomePage
@AuthorizeInstantiation("USER")
public class HomePage extends WebPage {

}
