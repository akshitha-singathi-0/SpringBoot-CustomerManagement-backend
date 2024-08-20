package com.samplename.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class RootController {
	
	@GetMapping
	public String onRoot() {
		return "<h3>The API is up and running!</h3>";
	}
	

}

