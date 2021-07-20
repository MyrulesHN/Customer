package com.application.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class Customer {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2",strategy = "org.hibernate.id.UUIDGenerator")
    private String customerId;
    @NotNull(message = "Please provide first name")
    private String firstName;
    @NotNull(message = "Please provide last name")
    private String lastName;
    @NotNull(message = "Please provide email id")
    private String email;

    @OneToMany(targetEntity=Address.class,cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="cp_fk",referencedColumnName = "customerId")
    private List<Address> address;

}
