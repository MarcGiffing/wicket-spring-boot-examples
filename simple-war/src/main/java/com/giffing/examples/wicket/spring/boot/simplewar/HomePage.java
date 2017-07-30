package com.giffing.examples.wicket.spring.boot.simplewar;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.giffing.wicket.spring.boot.starter.web.servlet.websocket.WebSocketMessageBroadcaster;

@WicketHomePage
public class HomePage extends WebPage {
	
	Label currentTime;
	
	public HomePage() {
		currentTime = new Label( "currentTime", "no time" );
		currentTime.setOutputMarkupId( true );
		add(currentTime);
		
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
