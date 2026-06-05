package com.spring_tut.jpa_entities.controller;

import com.spring_tut.jpa_entities.dtos.UserRequestDTO;
import com.spring_tut.jpa_entities.dtos.UserResponse;
import com.spring_tut.jpa_entities.modals.UserDetails;
import com.spring_tut.jpa_entities.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService=userService;
    }


    @PostMapping("/api/users")
    public ResponseEntity<UserResponse> insertUser(@Valid  @RequestBody UserRequestDTO userRequestDTO)
    {

       UserDetails userDetails=userService.insertUserInDB(userRequestDTO);

        UserResponse userResponse=new UserResponse(userDetails.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);

    }

    @GetMapping("/api/user/{name}")
    public ResponseEntity<List<UserDetails>> getAllUsers(@PathVariable("name") String userName)
    {

        return ResponseEntity.accepted().body(userService.getUsers(userName));

    }


}
