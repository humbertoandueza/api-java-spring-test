package com.azurian.apirest.model.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ClientDto implements Serializable {

    private Long clientId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;

}
