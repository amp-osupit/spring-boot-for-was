package au.com.amp.esi.test.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
		ExtPropertyConfig.class, //load external properties
		SharedBeanConfig.class, // set up shared beans
		WebConfig.class, //set web beans (e.g. dispatcher servlets)
})
public class AppConfig {

	//method to start when standalone or test mode
	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

}
