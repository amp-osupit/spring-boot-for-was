package au.com.amp.esi.test.springboot.config;

import au.com.amp.esi.test.springboot.web.dispatchers.ds0.DS0Config;
import au.com.amp.esi.test.springboot.web.dispatchers.ds1.DS1Config;
import au.com.amp.esi.test.springboot.web.dispatchers.root.RootConfig;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static au.com.amp.esi.spring.SpringWebHelper.createServletRegistrationBean;

/*
	Configure/create web related beans (eg dispatcher servlets, filters )
 */
@Configuration
public class WebConfig {


	@Bean
	public ServletRegistrationBean rootContextDs(){
		return createServletRegistrationBean(RootConfig.class, "dispatcherServlet", "/");
	}

	@Bean
	public ServletRegistrationBean ds0(){
		return createServletRegistrationBean( DS0Config.class, "ds0",  "/ds0/*");
	}

	@Bean
	public ServletRegistrationBean ds1(){
		return createServletRegistrationBean(DS1Config.class, "ds1", "/ds1/*");
	}


}
