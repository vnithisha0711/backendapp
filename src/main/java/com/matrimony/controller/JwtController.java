package com.matrimony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.entity.JwtRequest;
import com.matrimony.entity.JwtResponse;
//import com.matrimony.entity.JwtRequest;
//import com.matrimony.entity.JwtResponse;
import com.matrimony.service.JwtService;

@RestController

public class JwtController {
	
	@Autowired
	private JwtService jwtService;
	
   
	
	@PostMapping({"/authenticate"})
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		return jwtService.createJwtToken(jwtRequest);
		
	}
}