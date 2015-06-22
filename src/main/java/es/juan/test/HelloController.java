package es.juan.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping(value = "/upload", method=RequestMethod.POST)
	public ResponseEntity<String> fileUploadExperimentData(@RequestParam("file") MultipartFile file) {
    	System.out.println(file.getOriginalFilename());
    	System.out.println(file.getSize());
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
}
