package com.giffing.examples.wicket.spring.boot.simple;

import java.util.Date;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.protocol.ws.api.WebSocketBehavior;
import org.apache.wicket.protocol.ws.api.WebSocketRequestHandler;
import org.apache.wicket.protocol.ws.api.message.IWebSocketPushMessage;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.giffing.wicket.spring.boot.starter.web.servlet.websocket.WebSocketMessageBroadcaster;

@WicketHomePage
public class HomePage extends WebPage {
	
	@SpringBean
	private WebSocketMessageBroadcaster broadcaster;
	
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
		
		add(new AjaxLink("push") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				broadcaster.send( new DateEvent( new Date() ) );
				
			}
			
		});
		
		add(new WebSocketBehavior() {

			@Override
			protected void onPush(WebSocketRequestHandler handler, IWebSocketPushMessage message) {
				if(message instanceof DateEvent) {
					DateEvent de = (DateEvent) message;
					currentTime.setDefaultModelObject( de.getCurrentDate().toString() );
					handler.add( currentTime );
				}
			}
		});
		
	}
}
