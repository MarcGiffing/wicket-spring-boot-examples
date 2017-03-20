package com.giffing.examples.wicket.spring.boot.shirosecurity;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.giffing.wicket.spring.boot.context.scan.WicketSignInPage;

@WicketSignInPage
public class LoginPage extends WebPage {

	public LoginPage(PageParameters parameters) {
		super( parameters );

		add( new LoginForm( "loginForm" ) );
	}

	private class LoginForm extends Form<LoginForm> {

		private String username;

		private String password;

		public LoginForm(String id) {
			super( id );
			setModel( new CompoundPropertyModel<>( this ) );
			add( new FeedbackPanel( "feedback" ) );
			add( new RequiredTextField<String>( "username" ) );
			add( new PasswordTextField( "password" ) );
		}

		@Override
		protected void onSubmit() {
			if ( login( username, password, false ) ) {
				setResponsePage( new HomePage() );
			}
			else {
				error( "Login failed" );
			}
		}
	}

	public boolean login(final String username, final String password, final boolean rememberMe) {
		final Subject currentUser = SecurityUtils.getSubject();
		final UsernamePasswordToken token = new UsernamePasswordToken( username, password,rememberMe );
		try {
			currentUser.login( token );
			return true;
		}
		catch (final Exception ex) {
			error( "Login failed" );
		}
		return false;
	}
}
