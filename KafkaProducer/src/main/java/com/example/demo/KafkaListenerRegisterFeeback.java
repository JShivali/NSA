package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerRegisterFeeback {
	
	public static String registerAckMsg=null;

	@KafkaListener(topics="RegisterSuccessMessage", groupId ="group_id")
	public String consume(String message) {
		
		System.out.println("Come inside the Kafka register feedback");
		System.out.println("The register feeback message is"+message);		
		registerAckMsg=message;
		return "success";
		
	}
}
