package com.currencyconverter.controllers;

import com.currencyconverter.dto.UserDTO;
import com.currencyconverter.sevices.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user/")
public class UserController {

    private final UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(
            @RequestBody UserDTO userDTO
    ){

        logger.info("CREATE USER");

        return userService.createUser(userDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){

        logger.info("GET ALL USERS");

        return userService.getAllUsers();
    }


}
