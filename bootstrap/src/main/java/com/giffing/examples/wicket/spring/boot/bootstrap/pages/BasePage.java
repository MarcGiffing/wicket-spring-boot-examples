package com.giffing.examples.wicket.spring.boot.bootstrap.pages;

import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.giffing.examples.wicket.spring.boot.bootstrap.HomePage;

import de.agilecoders.wicket.core.markup.html.bootstrap.image.GlyphIconType;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarComponents;

public class BasePage extends GenericWebPage<Void> {

	public BasePage(final PageParameters parameters) {
        super(parameters);

        add(newNavbar("navbar"));
    }
	
	protected Navbar newNavbar(String markupId) {
        Navbar navbar = new Navbar(markupId);

        navbar.setPosition(Navbar.Position.TOP);
        navbar.setInverted(true);

        navbar.setBrandName(Model.of("Wicket Boot - Bootstrap"));

        navbar.addComponents(NavbarComponents.transform(Navbar.ComponentPosition.LEFT,
                        new NavbarButton<Void>(HomePage.class, Model.of("Home"))
                        	.setIconType(GlyphIconType.home)));


        return navbar;
    }
	
}
