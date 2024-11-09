package com.example.meualuguel.services;

import com.example.meualuguel.models.User;
import com.example.meualuguel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, Long> {

    @Autowired
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }
}
