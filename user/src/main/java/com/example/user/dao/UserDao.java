package com.example.user.dao;

import com.example.user.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    User findByRef(String ref);
    User findByEmail(String email);
    int deleteByRef(String ref);
}
