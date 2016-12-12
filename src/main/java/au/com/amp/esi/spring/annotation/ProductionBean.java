package au.com.amp.esi.spring.annotation;
import org.springframework.context.annotation.Profile;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Profile(ProductionBean.PROFILE_NAME)
public @interface ProductionBean {

	public static final String PROFILE_NAME = "production";

}
