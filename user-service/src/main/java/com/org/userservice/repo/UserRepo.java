package com.org.userservice.repo;

import com.org.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
    public User findOneByEmail(String email);
}
