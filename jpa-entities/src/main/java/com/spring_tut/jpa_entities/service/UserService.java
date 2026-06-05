package com.spring_tut.jpa_entities.service;

import com.spring_tut.jpa_entities.dtos.OrderDetailsDTO;
import com.spring_tut.jpa_entities.dtos.UserAddresssDTO;
import com.spring_tut.jpa_entities.dtos.UserRequestDTO;
import com.spring_tut.jpa_entities.modals.OrderDetails;
import com.spring_tut.jpa_entities.modals.UserAddress;
import com.spring_tut.jpa_entities.modals.UserDetails;
import com.spring_tut.jpa_entities.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

   private UserRepository userRepository;

   public UserService(UserRepository userRepository)
   {
       this.userRepository=userRepository;
   }

    public UserDetails insertUserInDB(UserRequestDTO userRequestDTO)
    {
       UserAddresssDTO userAddresssDTO= userRequestDTO.getUserAddresssDTO();

        UserAddress userAddress=new UserAddress(userAddresssDTO.getStreet(),userAddresssDTO.getZipcode());
        List<OrderDetailsDTO> orderList=userRequestDTO.getOrderDetailsDTOList();

        List<OrderDetails> orderDetails=orderList.stream().map(o->
                new OrderDetails(o.getProductName()))
                .toList();

        UserDetails userDetails=new UserDetails(userAddress,userRequestDTO.getName(),
                LocalDate.now(),orderDetails,userRequestDTO.getEmailid());

       return userRepository.save(userDetails);

    }

    public List<UserDetails> getUsers(String userName)
    {
        Pageable pageable= PageRequest.of(0,5);
        Page<UserDetails> userDetails= userRepository.findByName(userName,pageable);
        List<UserDetails> userDetailsList=userDetails.getContent();
        System.out.println("Total pages: "+userDetails.getTotalPages());

        return userDetailsList;

    }

}
