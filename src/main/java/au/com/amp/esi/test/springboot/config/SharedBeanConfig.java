package au.com.amp.esi.test.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
//load beans from packages defined in application.properties in default context
@ComponentScan(basePackages = {
		"${service.package}"
		})
public class SharedBeanConfig {

}
