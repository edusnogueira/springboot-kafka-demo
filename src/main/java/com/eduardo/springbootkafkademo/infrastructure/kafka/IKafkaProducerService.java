package com.eduardo.springbootkafkademo.infrastructure.kafka;

public interface IKafkaProducerService {    
 
    public void sendMessage(String topic, String msg);
}
