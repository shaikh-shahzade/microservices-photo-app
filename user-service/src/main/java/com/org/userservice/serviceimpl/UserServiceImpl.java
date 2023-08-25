package com.org.userservice.serviceimpl;

import com.org.userservice.model.User;
import com.org.userservice.repo.UserRepo;
import com.org.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public User getUser(String id) {

        return userRepo.findById(id).get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User createUser(User user) {
        user = userRepo.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        User u = userRepo.findById(user.getId()).get();
        u.setEmail(user.getEmail());
        u.setFname(user.getFname());
        u.setLname(user.getLname());
        u.setPassword(user.getPassword());
        user = userRepo.save(u);
        return user;
    }

    @Override
    public User deleteUser(String id) {
        User u = userRepo.findById(id).get();
        userRepo.delete(u);
        return u;
    }
}
