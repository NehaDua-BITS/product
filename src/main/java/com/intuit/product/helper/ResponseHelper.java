package com.intuit.product.helper;

import com.intuit.product.model.ValidationResponse;

import java.util.Random;

public class ResponseHelper {

    private static Random random;

    private static int limit;

    static {
        random = new Random();
        limit = ValidationResponse.values().length;
    }

    public static ValidationResponse getRandomResponse() {
//        ValidationResponse[] responses = ValidationResponse.values();
//        int index = random.nextInt(limit);
//        return responses[index];
        return ValidationResponse.ACCEPTED;
    }

}
