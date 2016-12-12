/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package au.com.amp.esi.test.springboot.dispatcher.hello;

import au.com.amp.esi.spring.annotation.IntegrationTestBean;
import au.com.amp.esi.test.springboot.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * Basic integration tests for service demo application.
 *
 * @author Dave Syer
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
//below causes the test/resources/application-integrationtest.properties to load and override the values in application.properties
@ActiveProfiles(IntegrationTestBean.PROFILE_NAME)
public class HelloWorldConfigurationTests {

	private static Logger log = LoggerFactory.getLogger(HelloWorldConfigurationTests.class);

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Value("${server.contextPath}")
	private String contextPath;

	@Test
	public void shouldReturn200WhenSendingRequestToOriginalHelloController() throws Exception {
		String testUrl = "http://localhost:" + this.port + contextPath + "/original/hello-world";
		log.info("test url for shouldReturn200WhenSendingRequestToOriginalHelloController is: {}", testUrl);
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(testUrl, Map.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}


	@Test
	public void shouldReturn200WhenSendingRequestToAltHelloController() throws Exception {
		String testUrl = "http://localhost:" + this.port + contextPath + "/alt/hello-world";
		log.info("test url for shouldReturn200WhenSendingRequestToAltHelloController is: {}", testUrl);
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(testUrl, Map.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void shouldReturn200WhenSendingRequestToManagementEndpoint() throws Exception {
		String testUrl = "http://localhost:" + this.mgt + "/info";
		log.info("test url for shouldReturn200WhenSendingRequestToManagementEndpoint is: {}", testUrl);
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(testUrl, Map.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	private void sleepForSeconds(int seconds) throws InterruptedException {
		log.debug("starting test - immediately sleeping for 20 seconds");
		Thread.sleep(new Long(seconds * 1000));
		log.debug("finished sleeping");
	}
}
