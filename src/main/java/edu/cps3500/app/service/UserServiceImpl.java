package edu.cps3500.app.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cps3500.app.domain.User;
import edu.cps3500.app.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public void save(User user) {
        System.out.println("CREATED USER.");
        userRepository.save(user);
    }
}