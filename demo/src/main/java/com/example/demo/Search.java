package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
class Search {
	@RequestMapping("/search")
	public String SearchAPI(@RequestParam(name="name", required = false, defaultValue = "null") String name){
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://swapi.dev/api/people/";
		String result[] = new String[11];
		for(int i=1;i<11;i++) {
			uri = uri + Integer.toString(i);
			result[i] = restTemplate.getForObject(uri, String.class);
			if(result[i].contains(name)) {
				return "found" + result[i]; 
			}
			result[i]="";
			uri="https://swapi.dev/api/people/";
		}
		//return "Not found";
		return "The name doesnt exist";
		}
	}
