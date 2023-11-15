package com.azurian.apirest.model.payload;

import com.azurian.apirest.model.dto.ClientDto;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@Data
@ToString
@Builder
public class MessageResponse<C> implements Serializable {

    private String message;
    private Object object;

    public static ResponseEntity<MessageResponse<ClientDto>> handleResponse(String message, HttpStatus httpStatus, Object object) {
        return ResponseEntity.status(httpStatus).body(MessageResponse.<ClientDto>builder().message(message).object(object).build());
    }

}
