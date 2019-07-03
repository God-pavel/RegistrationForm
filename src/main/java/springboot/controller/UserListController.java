package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.entity.User;
import springboot.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/all_users")
public class UserListController {
    @Autowired
    private UserService userService;


    @RequestMapping
    public List<User> getListOfUsers() {
        return userService.findAll();
    }
}