package es.juan.test.errorhandling.global;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.juan.test.exception.NotFoundException;

@RestController
@RequestMapping("/test/errorhandling/global")
public class DummyController {

	@RequestMapping(method=RequestMethod.GET)
	public String launchException() {
		throw new NotFoundException("Testing global error handling");
	}
}
