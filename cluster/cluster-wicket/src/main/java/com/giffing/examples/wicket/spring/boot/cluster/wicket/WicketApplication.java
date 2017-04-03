package com.giffing.examples.wicket.spring.boot.cluster.wicket;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.HazelcastSessionRepository;
import org.springframework.session.hazelcast.PrincipalNameExtractor;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapAttributeConfig;
import com.hazelcast.config.MapIndexConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@SpringBootApplication
@EnableHazelcastHttpSession
public class WicketApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder()
			.sources(WicketApplication.class)
			.run(args);
	}
	
	 @Bean
     public HazelcastInstance hazelcastInstance() {
             MapAttributeConfig attributeConfig = new MapAttributeConfig()
                             .setName(HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE)
                             .setExtractor(PrincipalNameExtractor.class.getName());

             Config config = new Config();

             config.getMapConfig("spring:session:sessions") 
                             .addMapAttributeConfig(attributeConfig)
                             .addMapIndexConfig(new MapIndexConfig(
                                             HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE, false));

             return Hazelcast.newHazelcastInstance(config); 
     }
}
