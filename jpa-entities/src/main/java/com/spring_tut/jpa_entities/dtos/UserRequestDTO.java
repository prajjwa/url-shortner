package com.spring_tut.jpa_entities.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;
@Data
public class UserRequestDTO {
    @NotNull
    private String emailid;
    @NotNull
    private String name;
    @NotNull
    private UserAddresssDTO userAddresssDTO;

    private List<OrderDetailsDTO> orderDetailsDTOList;


}
