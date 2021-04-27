package com.used.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	
	@Override //관리 하는 브로커인듯
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/send", "/aucring");
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		
		registry.addEndpoint("/").setAllowedOriginPatterns("*").withSockJS();
	}
	
	
	

}
