package edu.cps3500.app.service;

import edu.cps3500.app.domain.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}