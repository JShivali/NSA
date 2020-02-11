package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.apache.kafka.common.requests.ApiVersionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("kafka")
public class ApiGatewayResource {

	@Autowired
	KafkaTemplate<String,String> kafkaTemplate;
	private static final String TOPIC_LOGIN_MESSAGE= "KafkaLoginMessage";
	private static final String TOPIC_REGISTER_MESSAGE= "KafkaRegisterMessage";
	private static final String TOPIC_DATARETRIVE_MESSAGE= "KafkaDRMessage";
	
	@Autowired
	KafkaListenerRegisterFeeback registerAckService;
	@Autowired
	KafkaListenerLoginFeeback loginAckService;
	
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@RequestMapping(value="/login", method = RequestMethod.POST, consumes = "application/json")
	public String login(@RequestBody String message) throws InterruptedException {
		//String message=user.getFirstName();
		System.out.println("**************** OTIIII **********"+ message);
		kafkaTemplate.send(TOPIC_LOGIN_MESSAGE,message);
		
		String ack= loginAckService.returnFeedback();
		System.out.println("ack is"+ack);
		System.out.println("condition is"+ ack.equalsIgnoreCase("checking"));
	//	while(ack.equalsIgnoreCase("checking")) {
		TimeUnit.SECONDS.sleep(10);
		ack= loginAckService.returnFeedback();
		//}
		return ack;
	}
	
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@GetMapping("/register/{message}")
	public String register(@PathVariable("message") final String message) {
		kafkaTemplate.send(TOPIC_REGISTER_MESSAGE,message);
		//return new ApiVersionsResponse(HttpStatus.OK.value(), "User saved successfully.");
				//KafkaListenerRegisterFeeback.registerAckMsg;
		return "From successful register";
	}

	
	
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@GetMapping("/dataretrival")
	public String dataRetrival(@PathVariable("message") final String message) {
		kafkaTemplate.send(TOPIC_DATARETRIVE_MESSAGE,message);
		
		return "Reached API Gateway and pushed to Kafka";
	}
	
	
	@RequestMapping("/")
	public String showLoginForm() {

		return "Login.jsp";
	}
}
