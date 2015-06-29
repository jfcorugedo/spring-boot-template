package es.juan.test;

import java.net.URL;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

public class BaseIT {

	@Value("${local.server.port}")
    private int port;

	private URL base;
	private OAuth2RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		template = buildOauthRestTemplate();
	}
	
	private OAuth2RestTemplate buildOauthRestTemplate() {
		ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
		resource.setAccessTokenUri(base.toString() + "/oauth/token");
		resource.setClientId("my-trusted-client");
		resource.setClientSecret("secret");
		resource.setUsername("user@test.es");
		resource.setPassword("password");
		return new OAuth2RestTemplate(resource);
	}

	public int getPort() {
		return port;
	}

	public URL getBase() {
		return base;
	}

	public OAuth2RestTemplate getTemplate() {
		return template;
	}

}
