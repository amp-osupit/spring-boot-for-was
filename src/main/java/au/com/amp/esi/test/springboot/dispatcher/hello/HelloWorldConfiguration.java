package au.com.amp.esi.test.springboot.dispatcher.hello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration //designate this class as a config class that creates/returns Spring beans
@EnableWebMvc  //need this otherwise the web controllers found in component scan won't load
@ComponentScan(basePackages = "au.com.amp.esi.test.springboot.dispatcher.hello")
public class HelloWorldConfiguration {


}
