package au.com.amp.esi.test.springboot.dispatcher.althello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc  //need this otherwise the web controllers found in component scan won't load
@ComponentScan(basePackages = "au.com.amp.esi.test.springboot.dispatcher.althello")
public class AltHelloWorldConfiguration {

}
