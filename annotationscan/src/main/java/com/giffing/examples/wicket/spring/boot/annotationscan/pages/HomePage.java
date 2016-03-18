package com.giffing.examples.wicket.spring.boot.annotationscan.pages;

import org.wicketstuff.annotation.mount.MountPath;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;

@WicketHomePage
@MountPath("home")
public class HomePage extends BasePage {
}
