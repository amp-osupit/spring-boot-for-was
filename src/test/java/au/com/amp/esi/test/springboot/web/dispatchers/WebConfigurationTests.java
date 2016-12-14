package au.com.amp.esi.test.springboot.web.dispatchers;

import au.com.amp.esi.spring.annotation.IntegrationTestBean;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = AppConfig.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//below causes the test/resources/application-integrationtest.properties to load and override the values in application.properties
@ActiveProfiles(IntegrationTestBean.PROFILE_NAME)
@Slf4j
public class WebConfigurationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Value("${server.contextPath}")
	private String contextPath;

	@Test
	public void balanceOperationOnDs0Returns200() throws Exception {
		String testUrl = "http://localhost:" + this.port + contextPath + "/ds0/balance";
		log.info("test url for balanceOperationOnDs0Returns200 is: {}", testUrl);
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(testUrl, Map.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}


	@Test
	public void balanceOperationOnDs1Returns200() throws Exception {
		String testUrl = "http://localhost:" + this.port + contextPath + "/ds1/balance";
		log.info("test url for balanceOperationOnDs1Returns200 is: {}", testUrl);
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(testUrl, Map.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}


}
