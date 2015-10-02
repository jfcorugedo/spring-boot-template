package es.juan.test.scope.prototype;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.juan.test.Application;
import es.juan.test.BaseIT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes={Application.class})
@WebIntegrationTest
public class UsePrototypeScopeControllerIT extends BaseIT {

	@Test
	public void testGetDifferentRandomNumbersInEachRequest() {
		PrototypeComponent response1 = getRestTemplate().getForObject(getBase().toString() + "test/scope/prototype", PrototypeComponent.class);
		PrototypeComponent response2 = getRestTemplate().getForObject(getBase().toString() + "test/scope/prototype", PrototypeComponent.class);
		
		assertThat(response1.getNumber()).isNotEqualTo(response2.getNumber());
	}
}
