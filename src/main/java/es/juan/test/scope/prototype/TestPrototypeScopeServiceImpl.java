package es.juan.test.scope.prototype;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.stereotype.Service;

@Service
public class TestPrototypeScopeServiceImpl implements TestPrototypeScopeService{

	@Inject
	private Provider<PrototypeComponent> prototypeComponent;
	
	@Override
	public PrototypeComponent getPrototype() {
		
		return prototypeComponent.get();
	}
}
