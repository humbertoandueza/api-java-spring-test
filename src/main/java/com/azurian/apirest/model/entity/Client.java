package com.azurian.apirest.model.entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @Column(name="clientId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="address")
    private String address;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;

}
