package com.example.user.ws.provided;

import com.example.user.bean.User;
import com.example.user.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserWs {
    @Autowired
    private UserService userService;

    @GetMapping("/ref/{ref}")
    public User findByRef(@PathVariable String ref) {
        return userService.findByRef(ref);
    }

    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return userService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/")
    public int update(@RequestBody User user) {
        return userService.update(user);
    }

}
