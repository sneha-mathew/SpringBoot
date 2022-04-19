package com.smatoo.app.controller;

import java.util.Optional;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.smatoo.app.tracker.ITracker;

@RestController
public class AcceptController {
	@Autowired
	ITracker acceptService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/api/smaato/accept")
	public String accept( 
			@RequestParam(required = true)Integer id,  
			@RequestParam(required = false)Optional<String> endpoint) {
		 acceptService.add(id);
		 endpoint.ifPresent(s->callExternalRestCall(s));
		 return "ok";
	}
	private void callExternalRestCall(String url) {
		HttpEntity<Integer> request = 
				new HttpEntity<>(acceptService.currentCountUniqueRequest());
		logger.info( new RestTemplate()
		  .exchange(url, HttpMethod.GET, request, String.class)
		  .getStatusCode().toString());
	}
	@GetMapping("/error")
	public String error() {
		return "failed";
	}
}
