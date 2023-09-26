package com.org.userservice.serviceimpl;

import com.org.userservice.model.Album;
import com.org.userservice.model.User;
import com.org.userservice.repo.UserRepo;
import com.org.userservice.service.AlbumService;
import com.org.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private PasswordEncoder passwordEncoder;
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
        user.setId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user = userRepo.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        User u = userRepo.findById(user.getId()).get();
        u.setEmail(user.getEmail());
        u.setFname(user.getFname());
        u.setLname(user.getLname());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepo.save(u);
        return user;
    }

    @Override
    public User deleteUser(String id) {
        User u = userRepo.findById(id).get();
        userRepo.delete(u);
        return u;
    }

    @Override
    public List<Album> getAlbums() {
        Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

        logger.debug("Album service called");
        return albumService.getAlbums();

    }
}
