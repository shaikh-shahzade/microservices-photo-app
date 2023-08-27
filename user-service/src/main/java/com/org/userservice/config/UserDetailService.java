package com.org.userservice.config;

import com.org.userservice.model.User;
import com.org.userservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService  implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetail loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println(username + " " );
        User user = userRepo.findOneByEmail(username);
        System.out.println(username + " " + user.getEmail());
        return new UserDetail(user);
    }
}
