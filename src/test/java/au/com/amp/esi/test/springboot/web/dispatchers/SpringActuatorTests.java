package au.com.amp.esi.test.springboot.web.dispatchers;

import au.com.amp.esi.test.springboot.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = AppConfig.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
//below causes the test/resources/application-integrationtest.properties to load and override the values in application.properties
@Slf4j
public class SpringActuatorTests {

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Value("${management.context-path}")
	private String contextPath;


	@Autowired
	private TestRestTemplate testRestTemplate;


	@Test
	public void shouldReturn200WhenSendingRequestToManagementEndpoint() throws Exception {
		String testUrl = "http://localhost:" + this.mgt +  contextPath + "/info";
		log.info("test url for shouldReturn200WhenSendingRequestToManagementEndpoint is: {}", testUrl);
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(testUrl, Map.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}


}
