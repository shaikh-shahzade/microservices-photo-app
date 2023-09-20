package com.org.userservice.controller;

import com.org.userservice.model.Album;
import com.org.userservice.model.User;
import com.org.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("{id}")
    public User getUser(@PathVariable String id)
    {
        return userService.getUser(id);
    }
    @GetMapping()
    public List<User> getAllUser()
    {
        return userService.getAllUser();
    }
    @PostMapping
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }
    @PutMapping
    public User updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }

    @DeleteMapping("{id}")
    public User updateUser(@PathVariable String id)
    {
        return userService.deleteUser(id);
    }

    @GetMapping("albums")
    public List<Album> getAlbums()
    {
        return userService.getAlbums();
    }

}
