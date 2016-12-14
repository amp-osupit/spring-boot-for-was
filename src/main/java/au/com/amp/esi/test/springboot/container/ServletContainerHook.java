package au.com.amp.esi.test.springboot.container;

import au.com.amp.esi.test.springboot.config.AppConfig;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/*
	this class is the startup/entry point for Servlet 3.0 container to start this app
	- points to main Spring boot class
 */
public class ServletContainerHook extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AppConfig.class);
	}

}
