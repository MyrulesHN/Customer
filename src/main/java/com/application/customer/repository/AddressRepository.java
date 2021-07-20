package com.application.customer.repository;

import com.application.customer.entity.Address;
import com.application.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address,Integer> {
/*
    @Query("SELECT u FROM" )
    public Customer getAllAddressForCustomer(int customerId);*/
}
