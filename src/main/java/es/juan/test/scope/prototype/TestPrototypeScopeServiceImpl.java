package es.juan.test.scope.prototype;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.stereotype.Service;

import com.codahale.metrics.annotation.Gauge;

@Service
public class TestPrototypeScopeServiceImpl implements TestPrototypeScopeService{

	@Inject
	private Provider<PrototypeComponent> prototypeComponent;
	
	@Override
	@Gauge(name = "getMessage")
	public String getMessage(String name) {
		return String.format("Hello %s!!!!", name);
	}

	@Override
	public PrototypeComponent getPrototype() {
		
		return prototypeComponent.get();
	}
}
