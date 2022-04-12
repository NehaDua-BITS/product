package com.intuit.product.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.intuit.product.UpdateValidationResponseEvent;
import com.intuit.product.helper.ResponseHelper;
import com.intuit.product.kafka.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController("/profile/{profileId}/product/{productId}/validate")
public class ValidationController {

    @Autowired
    private Producer producer;

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity validate(@PathVariable(name = "profileId") String profileId,
                            @PathVariable(name = "productId") String productId,
                            @RequestBody Object event) throws JsonProcessingException, InterruptedException {
        log.info("Received validation request : profileId = {}, product = {}", profileId, productId);
        sendResponse(profileId, productId, event);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    private void sendResponse(String profileId, String productId, Object event) throws JsonProcessingException, InterruptedException {
        //send response after some time
        Thread.sleep(2000);

        //prepare response
        UpdateValidationResponseEvent updateResponseEvent = new UpdateValidationResponseEvent();
        updateResponseEvent.setResponse(ResponseHelper.getRandomResponse());
        updateResponseEvent.setEvent(event);
        updateResponseEvent.setSender(productId);
        updateResponseEvent.setProfileId(profileId);

        log.info("Sending Response : {}", updateResponseEvent);

        //push response to kafka
        producer.sendMessage(updateResponseEvent);
    }

}
