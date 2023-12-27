package com.example.user.service.impl;

import com.example.user.bean.User;
import com.example.user.dao.UserDao;
import com.example.user.service.facade.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByRef(String ref) {
        return userDao.findByRef(ref);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        if (userDao.findByRef(ref) != null) {
            userDao.deleteByRef(ref);
            return 1;
        } else return -1;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User save(User user) {
        if (userDao.findByRef(user.getRef()) != null) {
            return null;
        } else {
            return userDao.save(user);
        }
    }

    @Override
    public User authentification(User user) {
        User user1 = userDao.findByEmail(user.getEmail());

        if (user1 != null) {
            if (user.getPassword().equals(user.getPassword())) {
                return user;
            }
        }

        return null;
    }

    @Override
    public int update(User user) {
        if (user == null) {
            return -1;
        }else {
            User user1 = new User();
            user1.setId(user.getId());
            user1.setRef(user.getRef());
            user1.setNom(user.getNom());
            user1.setPrenom(user.getPrenom());
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            userDao.save(user1);
            return 1;
        }
    }

}
