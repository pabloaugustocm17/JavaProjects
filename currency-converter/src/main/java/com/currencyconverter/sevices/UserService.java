package com.currencyconverter.sevices;

import com.currencyconverter.dto.UserDTO;
import com.currencyconverter.mappers.UserMapper;
import com.currencyconverter.model.User;
import com.currencyconverter.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> createUser(UserDTO userDTO){

        Optional<User> existing_user = userRepository.findUserByEmail(userDTO.email());

        if(existing_user.isPresent()){
            logger.error("ERROR IN CREATE USER");
            return new ResponseEntity<>("User already exists", HttpStatusCode.valueOf(403));
        }

        User user = UserMapper.userMapper(userDTO);

        userRepository.save(user);
        logger.info("SUCESS IN SAVE USER");

        return ResponseEntity.ok(user.getId());

    }

    public ResponseEntity<?> getAllUsers(){

        return ResponseEntity.ok(userRepository.findAll());

    }

}
