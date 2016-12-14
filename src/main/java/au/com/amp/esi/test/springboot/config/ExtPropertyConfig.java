package au.com.amp.esi.test.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

//allows external classpath properties file based on app name to be specified but not required
@PropertySource(value = "classpath:${app.name}.properties", ignoreResourceNotFound=true)
public class ExtPropertyConfig {

	//this allows the properties file in the @PropertySource annotation (above) to be used across Spring controlled beans
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}


}
