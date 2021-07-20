package com.application.customer.service;

import com.application.customer.entity.Address;
import com.application.customer.entity.Customer;
import com.application.customer.repository.AddressRepository;
import com.application.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    @Transactional
    public Customer saveCustomers(Customer customer){
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomers(String customerId){
        return customerRepository.findById(customerId);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Address saveAddress(Address address){
        return (Address) addressRepository.save(address);
    }


   /* public Customer getAllForCustomer(int customerId){
        return addressRepository.findById(customerId);
    }*/
}
