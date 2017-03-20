package com.giffing.examples.wicket.spring.boot.shirosecurity;

import org.apache.shiro.event.EventBus;
import org.apache.shiro.event.EventBusAware;
import org.apache.shiro.event.Subscribe;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.wicketstuff.shiro.annotation.AnnotationsShiroAuthorizationStrategy;
import org.wicketstuff.shiro.authz.ShiroUnauthorizedComponentListener;

import com.giffing.wicket.spring.boot.context.extensions.WicketApplicationInitConfiguration;

@Component
@Configuration
public class ShiroInitializer implements WicketApplicationInitConfiguration {
    @Bean
    @SuppressWarnings("Duplicates")
    Realm getTextConfigurationRealm() {
        TextConfigurationRealm realm = new TextConfigurationRealm();
        realm.setUserDefinitions(
        		"user=user,user\n" +
                "admin=admin,admin");
        realm.setRoleDefinitions(
        		"admin=read,write\n" +
                "user=read");
        realm.setCachingEnabled(true);
        return realm;
    }
    @Bean
    ShiroFilterChainDefinition shiroFilterChainDefinition() {
        return new DefaultShiroFilterChainDefinition();
    }
    @Bean
    EventBusAwareObject eventBusAwareObject() {
        return new EventBusAwareObject();
    }
    @Bean
    SubscribedListener subscribedListener() {
        return new SubscribedListener();
    }
    public static class EventBusAwareObject implements EventBusAware {
        private EventBus eventBus;
        
        public void setEventBus(EventBus bus) {
            this.eventBus = bus;
        }
        public EventBus getEventBus() {
            return eventBus;
        }
    }
    public static class SubscribedListener {
        @Subscribe
        public void onEvent(Object object) {
        }
    }
    public void init(WebApplication app) {
        AnnotationsShiroAuthorizationStrategy authz = new AnnotationsShiroAuthorizationStrategy();
        app.getSecuritySettings().setAuthorizationStrategy(authz);
        app.getSecuritySettings().setUnauthorizedComponentInstantiationListener(new ShiroUnauthorizedComponentListener(LoginPage.class, LoginPage.class, authz));
    }
}