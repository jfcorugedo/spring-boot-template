package es.juan.test.scope.prototype;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UsePrototypeScopeController {
	
	@Inject TestPrototypeScopeService testService;
	
	@RequestMapping(value="/scope/prototype", method = RequestMethod.GET)
	public ResponseEntity<PrototypeComponent> getPrototype(){
	    return new ResponseEntity<PrototypeComponent>(testService.getPrototype(), HttpStatus.OK);
	}
}
