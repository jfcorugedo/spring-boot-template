package es.juan.test.scope.prototype;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/scope")
public class UsePrototypeScopeController {
	
	@Inject TestPrototypeScopeService testService;
	
	@RequestMapping(value="/get/{name}",  method = RequestMethod.GET)
	public ResponseEntity<String> getMethod(@PathVariable String name){
	    return new ResponseEntity<String>(testService.getMessage(name), HttpStatus.OK);
	}
	
	@RequestMapping(value="/prototype", method = RequestMethod.GET)
	public ResponseEntity<PrototypeComponent> getPrototype(){
	    return new ResponseEntity<PrototypeComponent>(testService.getPrototype(), HttpStatus.OK);
	}
}
