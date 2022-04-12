package com.intuit.product.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.intuit.product.helper.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {

    @Value("${kafka.producer.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(Object message) throws JsonProcessingException {
        String msg = Mapper.toJson(message);
        log.info(String.format("#### -> Sending Validation Response -> %s", msg));
        this.kafkaTemplate.send(topic, msg);
    }
}