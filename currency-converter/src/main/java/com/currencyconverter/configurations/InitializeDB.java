package com.currencyconverter.configurations;

import com.currencyconverter.model.User;
import com.currencyconverter.repositories.UserRepository;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class InitializeDB {

    private final UserRepository userRepository;

    public InitializeDB(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @EventListener(ApplicationStartedEvent.class)
    public void initilize(){
        initializeUsers();
    }

    private void initializeUsers(){

        User user = new User("pablo", "pablo@email.com", "password");
        User user_1 = new User("augusto", "augusto@email.com", "augusto");

        userRepository.save(user);
        userRepository.save(user_1);

    }

}
