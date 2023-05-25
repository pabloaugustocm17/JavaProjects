package com.currencyconverter.mappers;

import com.currencyconverter.dto.UserDTO;
import com.currencyconverter.model.User;

public class UserMapper {

    public static User userMapper(UserDTO userDTO){

        return new User(
                userDTO.name(),
                userDTO.email(),
                userDTO.password()
        );

    }

}
