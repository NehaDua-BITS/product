package com.intuit.product.dao;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class ValidationRequestStore {

    private Map<UUID, Object> store = new HashMap<>();

    public void addRequest(UUID profileId, UUID productId, Object event) {

    }

}
