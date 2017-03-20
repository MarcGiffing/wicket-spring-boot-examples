package com.giffing.examples.wicket.spring.boot.shirosecurity;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.wicketstuff.shiro.ShiroConstraint;
import org.wicketstuff.shiro.annotation.ShiroSecurityConstraint;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;

@WicketHomePage
@ShiroSecurityConstraint(constraint = ShiroConstraint.HasRole, value = "admin", loginMessage = "You must be logged in to view this page", unauthorizedMessage = "You need to be an ADMIN")
public class HomePage extends WebPage {
	
	public HomePage() {
		Form form = new Form("form"){
			@Override
			protected void onSubmit() {
					setResponsePage(SecondPage.class);
			}
		};
		queue(form);
		
		
		add(new Link<Void>("mylink") {

					@Override
					public void onClick() {
						setResponsePage(SecondPage.class);
					}
		        	
		        });
	}
}
