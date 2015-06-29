package es.juan.test.i18n;

import javax.inject.Inject;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/i18n")
public class TextController {

	@Inject
	private MessageSource messageSource;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getText(@RequestParam String key) {
		return messageSource.getMessage(key, null, "Not found!!", LocaleContextHolder.getLocale());
	}
}
