package com.giffing.examples.wicket.spring.boot.cluster.wicket;

import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.stereotype.Component;

import com.giffing.wicket.spring.boot.context.extensions.WicketApplicationInitConfiguration;


@Component
public class WicketConfig implements WicketApplicationInitConfiguration {

	@Override
	public void init(WebApplication webApplication) {
//		webApplication.getRequestLoggerSettings().setRequestLoggerEnabled( true );
		
	}

}
