package com.intuit.product.helper;

import com.intuit.product.constants.ResponseType;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

public class ResponseHelper {

    private static Random random;

    private static int limit;

    public ResponseHelper() {
        this.random = new Random();
        this.limit = ResponseType.values().length + 1;
    }

    public static ResponseType getRandomResponse() {
        ResponseType[] responses = ResponseType.values();
        int index = random.nextInt(limit)-1;
        return responses[index];
    }

}
