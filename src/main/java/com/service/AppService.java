package com.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.FeedBackResponse;
import com.model.FeedbackEntity;

//import com.repo.AppOwnerRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class AppService {
	
	@Autowired
	@Qualifier("webclient")
	private WebClient.Builder builder;
	
//	@Autowired
//	private AppOwnerRepo repo;
	
	@CircuitBreaker(fallbackMethod="fallbackMethod", name = "cb")
	public List<FeedBackResponse> processAndSendAllUnAcknowleged() {
//		ObjectMapper mapper = new ObjectMapper();
		String feedBackServiceURL = "http://localhost:8010/feedback/getUnAcknowlegedFeedbacks/";
//		FeedbackEntity entity;
		List<FeedbackEntity> unAcknowledgedFeedBackList= builder.build()
				.get()
				.uri(feedBackServiceURL)
				.retrieve()
				.bodyToFlux(FeedbackEntity.class)
				.collectList()
				.block();
		System.out.println(feedBackServiceURL);
		System.out.println(unAcknowledgedFeedBackList);
		List<FeedBackResponse> feedbackResponseList = new ArrayList<>();

		for(FeedbackEntity l:unAcknowledgedFeedBackList) {
			feedbackResponseList.add(
					FeedBackResponse.builder()
					.feedbackId(l.getFeedbackId())
					.feedbackTitle(l.getFeedbackTitle())
					.feedbackFrom(l.getFeedbackFrom())
					.feedbackBody(l.getFeedbackBody())
					.feedbackDate(l.getFeedbackDate())
					.feedbackAcknowledge(l.getFeedbackAcknowledge())
					.build()
					);
		}
		return feedbackResponseList;
	}
	
	@CircuitBreaker(fallbackMethod="fallbackMethod", name = "cb")
	public List<FeedBackResponse> processAndSendAllAcknowleged() {
//		ObjectMapper mapper = new ObjectMapper();
		String feedBackServiceURL = "http://localhost:8010/feedback/getAcknowlegedFeedbacks/";
//		FeedbackEntity entity;
		List<FeedbackEntity> acknowledgedFeedBackList= builder.build()
				.get()
				.uri(feedBackServiceURL)
				.retrieve()
				.bodyToFlux(FeedbackEntity.class)
				.collectList()
				.block();
		System.out.println(feedBackServiceURL);
		System.out.println(acknowledgedFeedBackList);
		List<FeedBackResponse> feedbackResponseList = new ArrayList<>();

		for(FeedbackEntity l:acknowledgedFeedBackList) {
			feedbackResponseList.add(
					FeedBackResponse.builder()
					.feedbackId(l.getFeedbackId())
					.feedbackTitle(l.getFeedbackTitle())
					.feedbackFrom(l.getFeedbackFrom())
					.feedbackBody(l.getFeedbackBody())
					.feedbackDate(l.getFeedbackDate())
					.feedbackAcknowledge(l.getFeedbackAcknowledge())
					.build()
					);
		}
		return feedbackResponseList;
	}
	@CircuitBreaker(fallbackMethod="fallbackMethod", name = "cb")
	public List<FeedBackResponse> processAndSendByOwner() {
//		ObjectMapper mapper = new ObjectMapper();
		String feedBackServiceURL = "http://localhost:8010/feedback/getFeedbacksByOner/";
//		FeedbackEntity entity;
		List<FeedbackEntity> acknowledgedFeedBackList= builder.build()
				.get()
				.uri(feedBackServiceURL)
				.retrieve()
				.bodyToFlux(FeedbackEntity.class)
				.collectList()
				.block();
		System.out.println(feedBackServiceURL);
		System.out.println(acknowledgedFeedBackList);
		List<FeedBackResponse> feedbackResponseList = new ArrayList<>();

		for(FeedbackEntity l:acknowledgedFeedBackList) {
			feedbackResponseList.add(
					FeedBackResponse.builder()
					.feedbackId(l.getFeedbackId())
					.feedbackTitle(l.getFeedbackTitle())
					.feedbackFrom(l.getFeedbackFrom())
					.feedbackBody(l.getFeedbackBody())
					.feedbackDate(l.getFeedbackDate())
					.feedbackAcknowledge(l.getFeedbackAcknowledge())
					.build()
					);
		}
		return feedbackResponseList;
		
	}
	
	

	
	public FeedBackResponse fallbackMethod() {
		System.out.println("Arey Bhai aise kese chalega!!!");
		return FeedBackResponse.builder()
				.feedbackId(-1)
				.build();
	}

	
	
}
