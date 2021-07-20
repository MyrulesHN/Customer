package com.application.customer.service;

import com.application.customer.entity.Address;
import com.application.customer.entity.Customer;
import com.application.customer.model.CustomerAddress;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ValidationService {

    @Autowired
    Validator validator;

    public Map<String,String> validateRequest(CustomerAddress customerAddress) {
        Map<String, String> errorMap = new HashMap<>();
        if (ObjectUtils.isEmpty(customerAddress.getCustomer())) {
            errorMap.put("Customer", "Customer Details can't be empty");
        }

        if (checkForNullAndBlank(customerAddress.getCustomer().getFirstName())) {
            errorMap.put("FirstName", "FirstName can't be empty");
        }
        if (checkForNullAndBlank(customerAddress.getCustomer().getLastName())) {
            errorMap.put("LastName", "LastName can't be empty");
        }

        if (checkForNullAndBlank(customerAddress.getCustomer().getEmail())) {
            errorMap.put("Email", "Email can't be empty");
        }
        if (ObjectUtils.isEmpty(customerAddress.getCustomer().getAddress())) {
            errorMap.put("Address", "Address can't be empty");
        }

        //List<Boolean> addressValidation =
                customerAddress.getCustomer().getAddress()
                .stream()
                .filter( (a) -> {
                    if(checkForNullAndBlank(a.getCity())
                    || checkForNullAndBlank(a.getZipcode())
                    || checkForNullAndBlank(a.getCountry()))
                        return true;
                    return false;
                } );

                        /*a-> checkForNullAndBlank(a.getCity())
                       || checkForNullAndBlank(a.getZipcode())
                       || checkForNullAndBlank(a.getCity()));
*/

      /*  if (addressValidation.stream().count() > 1) {
            errorMap.put("address", "Country or zipcode or city can't be empty");
        }*/
        return errorMap;
    }
        private boolean checkForNullAndBlank(String string){
            if (StringUtils.isEmpty(string) || StringUtils.isBlank(string)) {
                return true;
            } else {
                return false;
            }
        }

    }

