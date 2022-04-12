package com.intuit.product;

import com.intuit.product.constants.ResponseType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateValidationResponseEvent {

    private String profileId;

    private Object event;

    private String sender;

    private ResponseType response;

}
