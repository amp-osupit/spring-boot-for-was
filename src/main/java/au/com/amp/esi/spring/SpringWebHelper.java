package au.com.amp.esi.spring;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebHelper {

	public static  ServletRegistrationBean createServletRegistrationBean(Class configClass, String servletName, String ... urlMappings){
		// Create the dispatchers servletRegistrationBean's Spring application context
		AnnotationConfigWebApplicationContext dispatcherContext =
				new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(configClass);
		ServletRegistrationBean servletRegistrationBean =
				new ServletRegistrationBean(new DispatcherServlet(dispatcherContext));
		servletRegistrationBean.setName(servletName);
		servletRegistrationBean.addUrlMappings(urlMappings);
		//initialise servlet on app startup with setLoadOnStartup(1) - otherwise initialises on first request
		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}
}
