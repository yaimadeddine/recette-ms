package com.example.user.service.facade;

import com.example.user.bean.User;

import java.util.List;

public interface UserService {
    User findByRef(String ref);
    User findByEmail(String email);
    int deleteByRef(String ref);
    List<User> findAll();
    int save(User user);
    int update(User user);
}
