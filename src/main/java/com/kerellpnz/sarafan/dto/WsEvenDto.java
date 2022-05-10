package com.kerellpnz.sarafan.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonView;
import com.kerellpnz.sarafan.domain.Views;
import lombok.Data;

@Data
@JsonView(Views.Id.class)
public class WsEvenDto {
    private ObjectType objectType;
    private EventType eventType;

    @JsonRawValue
    private String body;

    public WsEvenDto(ObjectType objectType, EventType eventType, String body) {
        this.objectType = objectType;
        this.eventType = eventType;
        this.body = body;
    }
}
