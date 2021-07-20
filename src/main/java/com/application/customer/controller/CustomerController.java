package com.application.customer.controller;

import com.application.customer.entity.Address;
import com.application.customer.entity.Customer;
import com.application.customer.model.CustomerAddress;
import com.application.customer.service.CustomerService;
import com.application.customer.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@EnableTransactionManagement
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ValidationService validationService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerAddress customerAddress) {
        Map<String, String> errorMap = validationService.validateRequest(customerAddress);
        if (!errorMap.isEmpty()) {
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(customerService.saveCustomers(customerAddress.getCustomer()),HttpStatus.OK);

        }
    }

    @GetMapping("/customerDetails/{custId}")
    public ResponseEntity<?> getCustomerDetails(@Valid @PathVariable String custId) {
        return customerService.getCustomers(custId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());

    }

    @GetMapping("/custDetails")
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
