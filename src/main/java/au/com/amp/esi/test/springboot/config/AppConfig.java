package au.com.amp.esi.test.springboot.config;

import au.com.amp.esi.test.springboot.dispatcher.althello.AltHelloWorldConfiguration;
import au.com.amp.esi.test.springboot.dispatcher.hello.HelloWorldConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import static au.com.amp.esi.spring.SpringWebHelper.createServletRegistrationBean;

@SpringBootApplication
//load spring beans from packages defined in application.properties in default context
@ComponentScan(basePackages = {"${service.package}"})
//allows external classpath properties file to specified but not required be used
@PropertySource(value = "classpath:${app.name}.properties", ignoreResourceNotFound=true)
public class AppConfig extends SpringBootServletInitializer {

	//method to configure app when in servlet  container
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AppConfig.class);
	}

	//method to start when standalone or test mode
	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

	//this allows the properties file in the @PropertySource annotation (above) to be used across Spring controlled beans
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	//Dispatcher servlet config here

	//hello dispatcher
	@Bean
	public ServletRegistrationBean helloServlet(){
		return createServletRegistrationBean( HelloWorldConfiguration.class, "original",  "/original/*");
	}

	//alt hello dispatcher
	@Bean
	public ServletRegistrationBean altHelloServlet(){
		return createServletRegistrationBean(AltHelloWorldConfiguration.class, "alt", "/alt/*");
	}

}
