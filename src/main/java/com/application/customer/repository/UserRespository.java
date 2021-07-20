package com.application.customer.repository;

import com.application.customer.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<Users,Integer> {

    public Users findByUsername(String userName);
}
