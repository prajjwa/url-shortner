package com.spring_tut.jpa_entities.modals;

import com.spring_tut.jpa_entities.dtos.UserAddresssDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.Order;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="UserDetails")
@Data
@NoArgsConstructor
public class UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public UserDetails(UserAddress userAddress, String name, LocalDate createdAt, List<OrderDetails> orderDetails, String emailid) {
        this.userAddress = userAddress;
        this.name = name;
        this.createdAt = createdAt;
        this.orderDetails = orderDetails;
        this.emailid = emailid;
    }

    @OneToOne(cascade=CascadeType.ALL)
    private UserAddress userAddress;
    private String name;
    private LocalDate createdAt;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userDetails")
    private List<OrderDetails> orderDetails;

    private String emailid;





}
