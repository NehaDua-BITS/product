package com.intuit.product.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateEvent {

    protected String eventType;

    protected String requestId;

    private String userId;

    private String profileDTO;

    private ZonedDateTime updateTime;

    private String source;

}
