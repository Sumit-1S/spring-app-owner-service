package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.FeedBackResponse;

import com.service.AppService;

@RestController
@RequestMapping("/AppOwner")

public class AppController {
	
	@Autowired
	private AppService service;
	

	
	@GetMapping("/allUnAcknowledgedFeedback")
	private ResponseEntity getAllUnAcknowledgedFeedBack() {
		List<FeedBackResponse> responseList=service.processAndSendAllUnAcknowleged();
		
		
		return new ResponseEntity(responseList,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/allAcknowledgedFeedback")
	private ResponseEntity getAllAcknowledgedFeedBack() {
		List<FeedBackResponse> responseList=service.processAndSendAllAcknowleged();
		
		
		return new ResponseEntity(responseList,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/allFeedbackByOwner")
	private ResponseEntity getAllFeedBackByOwner() {
		List<FeedBackResponse> responseList=service.processAndSendByOwner();
		
		
		return new ResponseEntity(responseList,HttpStatus.CREATED);
		
	}
	
	
	
	

}
