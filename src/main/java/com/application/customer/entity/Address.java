package com.application.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int houseNumber;
    private String streetNumber;
    private String streetName;
    private String streetAddress;
    private String city;
    private String state;
    @NotNull(message = "Please provide the zipcode")
    private String zipcode;
    @NotNull
    @Size(min=2,message = "Please provide country name with Mre than 2 characters")
    private String country;
    private String phone;
}
