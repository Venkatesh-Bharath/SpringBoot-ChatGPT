package com.example.ChatBot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.ChatBot.model.ChatGptRequest;
import com.example.ChatBot.model.ChatGptResponse;

@RestController
public class ChatBotController {
	@Value("${chatgpt.model}")
	private String model;
	@Value("${chatgpt.api.url}")
	private String apiUrl;
	@Value("${chatgpt.api.key}")
	private String apiKey;
	
	private static RestTemplate restTemplate=new RestTemplate();
	
	@PostMapping("/request")
	public String
	chatBot(@RequestBody String content) {
		ChatGptRequest request=new ChatGptRequest(model,content);
		HttpHeaders header=new HttpHeaders();
		header.add("Authorization", "Bearer "+apiKey);
		ChatGptResponse chatGptResponse=
				restTemplate.postForObject(apiUrl, new HttpEntity<>(request,header), ChatGptResponse.class);
		return chatGptResponse.getChoices().get(0).getMessage().getContent();
	}

}
