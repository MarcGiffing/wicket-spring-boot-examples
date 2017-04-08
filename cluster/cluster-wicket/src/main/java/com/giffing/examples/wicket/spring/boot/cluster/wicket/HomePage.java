package com.giffing.examples.wicket.spring.boot.cluster.wicket;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;

@WicketHomePage
@MountPath("home")
@AuthorizeInstantiation("USER")
public class HomePage extends WebPage {

	private AtomicInteger counter = new AtomicInteger( 1 );
	
	public HomePage() {
		System.out.println( "call home page" );
		Label counterLabel = new Label("counterLabel", new LoadableDetachableModel<AtomicInteger>(counter) {

			@Override
			protected AtomicInteger load() {
				return counter;
			}
		});
		counterLabel.setOutputMarkupId( true );
		
		AjaxLink link = new AjaxLink("click") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				System.out.println( counter.incrementAndGet());
				target.add( counterLabel );
			}
		};
		
		add(counterLabel);
		add(link);
	}
	
}
