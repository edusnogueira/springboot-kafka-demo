package com.eduardo.springbootkafkademo.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.springbootkafkademo.controller.dto.DemoDTO;
import com.eduardo.springbootkafkademo.domain.model.DemoObject;
import com.eduardo.springbootkafkademo.infrastructure.kafka.IKafkaProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/kafka-demo/v1")
public class DemoController {

    ObjectMapper mapper;
    IKafkaProducerService producer;
    @Value("${producer.topic}")
    String demoTopic;

    private DemoController(IKafkaProducerService producer, ObjectMapper mapper) {
        this.producer = producer;
        this.mapper = mapper;
    }

    @PostMapping("/create-event")
    public ResponseEntity<?> postModelToKafka(@RequestBody DemoDTO request) throws JsonProcessingException {
        DemoObject demo = DemoObject.builder()
                                    .age(request.getAge())
                                    .name(request.getName())
                                    .storesToAccess(request.getStoresToAccess().stream().collect(Collectors.toSet()))
                                    .build();

        producer.sendMessage(demoTopic, mapper.writeValueAsString(demo));

        return ResponseEntity.accepted().build();
    }
}

/*
curl -d '{         
    "name": "edu",
    "age": "30",
    "stores_to_access" : [1234,1234,4321]
}' -X POST -H "Content-Type: application/json" http://localhost:8080/kafka-demo/v1/create-event 
*/