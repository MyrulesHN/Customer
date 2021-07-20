package com.application.customer.model;

import com.application.customer.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NegativeOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {
    private Customer customer;
}
