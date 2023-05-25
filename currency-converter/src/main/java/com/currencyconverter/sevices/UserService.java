package com.currencyconverter.sevices;

import com.currencyconverter.dto.UserDTO;
import com.currencyconverter.mappers.UserMapper;
import com.currencyconverter.model.User;
import com.currencyconverter.repositories.UserRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> createUser(UserDTO userDTO){

        Optional<User> existing_user = userRepository.findUserByEmail(userDTO.email());

        if(existing_user.isPresent()){
            return new ResponseEntity<>("User already exists", HttpStatusCode.valueOf(403));
        }

        User user = UserMapper.userMapper(userDTO);

        userRepository.save(user);

        return ResponseEntity.ok(user.getId());

    }

}
