package com.spring_tut.jpa_entities.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String zipCode;
    private String street;

    public UserAddress(String street, String zipcode) {
        this.street=street;
        this.zipCode=zipcode;
    }
}
