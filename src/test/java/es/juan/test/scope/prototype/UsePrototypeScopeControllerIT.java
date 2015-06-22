package es.juan.test.scope.prototype;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import es.juan.test.Application;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes={Application.class})
@WebIntegrationTest
public class UsePrototypeScopeControllerIT {

	@Value("${local.server.port}")
    private int port;

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		template = new RestTemplate();
	}
	
	@Test
	public void testGetDifferentRandomNumbersInEachRequest() {
		PrototypeComponent response1 = template.getForObject(base.toString() + "test/scope/prototype", PrototypeComponent.class);
		PrototypeComponent response2 = template.getForObject(base.toString() + "test/scope/prototype", PrototypeComponent.class);
		
		assertThat(response1.getNumber()).isNotEqualTo(response2.getNumber());
	}
}
