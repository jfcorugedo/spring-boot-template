package es.juan.test.i18n;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.*;
import es.juan.test.Application;
import es.juan.test.BaseIT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
@WebIntegrationTest
public class TextControllerIT extends BaseIT {

	@Test
	public void testGetText() {
		String sampleText = getRestTemplate().getForObject(getBase() + "test/i18n?key=sample.text", String.class);
		
		assertThat(sampleText).isEqualTo("What ever happened to you?");
	}
}
