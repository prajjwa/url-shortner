package com.spring_tut.jpa_entities.modals;

import jakarta.persistence.*;

@Table(name="order_details")
@Entity
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public OrderDetails(String productName) {
        this.productName = productName;
    }

    private String productName;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserDetails userDetails;
}
