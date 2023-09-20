package com.org.userservice.service;

import com.org.userservice.model.Album;
import com.org.userservice.model.User;

import java.util.List;

public interface UserService {

    User getUser(String id);

    List<User> getAllUser();

    User createUser(User user);

    User updateUser(User user);

    User deleteUser(String id);

    List<Album> getAlbums();
}
