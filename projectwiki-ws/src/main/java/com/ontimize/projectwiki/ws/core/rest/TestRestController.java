package com.ontimize.projectwiki.ws.core.rest;

import com.ontimize.projectwiki.openapi.core.dto.Person;
import com.ontimize.projectwiki.openapi.core.service.ITestApi;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/test")
public class TestRestController implements ITestApi {

	@Override
	public ResponseEntity<String> postTest(Person person) {
		return new ResponseEntity<>(String.format("Hi %s!", person.getName()), HttpStatus.OK);
	}

	//@RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ResponseEntity<String> testRest() {
		return new ResponseEntity<>("It Works!", HttpStatus.OK);
	}

}
