package com.elitesoftwarehouse.demo.service;

import com.elitesoftwarehouse.demo.model.MyUser;
import com.elitesoftwarehouse.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public MyUser save(MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public MyUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
