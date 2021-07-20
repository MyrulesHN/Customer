package com.application.customer.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="appuser")
public class Users {

    @Id
    private int id;
    private String username;
    private String password;
    private boolean active;

}
