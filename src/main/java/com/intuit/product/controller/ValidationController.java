package com.intuit.product.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.intuit.product.helper.ResponseHelper;
import com.intuit.product.model.ValidationResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/profile/{profileId}/product/{productId}/validate")
public class ValidationController {

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ValidationResponseDTO> validate(@PathVariable(name = "profileId") String profileId,
                            @PathVariable(name = "productId") String productId,
                            @RequestBody Object event) throws JsonProcessingException, InterruptedException {
        log.info("Received validation request : profileId = {}, product = {}", profileId, productId);
        ValidationResponseDTO responseDTO = prepareResponse(profileId, productId, event);
        log.info("Sending Response : {}", responseDTO);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

    private ValidationResponseDTO prepareResponse(String profileId, String productId, Object event) throws JsonProcessingException, InterruptedException {
        //prepare response
        ValidationResponseDTO responseDTO = new ValidationResponseDTO();
        responseDTO.setValidationResponse(ResponseHelper.getRandomResponse());
        responseDTO.setError(null);
        return responseDTO;
    }

}
