package com.nsa.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	KafkaTemplate<String,String> kafkaTemplate;
	private static final String TOPIC= "LoginSuccessMessage";

	@KafkaListener(topics="KafkaLoginMessage", groupId ="group_id")
	public void consume(String message) {
		
		System.out.println("Come inside the Kafka consumer ");
		
		// Use repository to check database based on the value given from MB to service
		User answer= userRepository.findByuserName(message);
		System.out.println("Consumed Message is"+message);
		System.out.println("db check output is"+answer);
		
		User checkByLastName= userRepository.findByLastName("Jejurkar");
		System.out.println("DB check after lastname"+checkByLastName);
		
		List<User> userList= (List<User>) userRepository.findAll();
		System.out.println(userList);
		
		
		boolean userExists=userRepository.existsById(2);
		
		if(userExists) {
			// load the User dashboard
			kafkaTemplate.send(TOPIC,"success");
		}
		else {
			// return message
		}
		
	}
}
