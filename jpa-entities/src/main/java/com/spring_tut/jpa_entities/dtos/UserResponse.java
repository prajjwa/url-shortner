package com.spring_tut.jpa_entities.dtos;

import lombok.Data;

@Data
public class UserResponse {
    private Integer userId;

    public UserResponse(Integer userId) {
        this.userId = userId;
    }
}
