package com.eduardo.springbootkafkademo.infrastructure.kafka.impl;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.eduardo.springbootkafkademo.infrastructure.kafka.IKafkaProducerService;

@Component
public class KafkaProducerServiceImpl implements IKafkaProducerService {
	
    private KafkaTemplate<String, String> kafkaTemplate;

    private KafkaProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
	
	@Override	
	public void sendMessage(String topic, String value) {
		
		kafkaTemplate.send(topic, value);
		
	}
}
