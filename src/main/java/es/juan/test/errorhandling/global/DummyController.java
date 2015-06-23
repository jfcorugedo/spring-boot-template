package es.juan.test.errorhandling.global;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.juan.test.exception.NotFoundException;

@RestController
public class DummyController {

	@RequestMapping("/test/errorhandling/global")
	public String launchException() {
		throw new NotFoundException("Testing global error handling");
	}
}
