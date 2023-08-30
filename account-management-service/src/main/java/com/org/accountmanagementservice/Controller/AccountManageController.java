package com.org.accountmanagementservice.Controller;

import com.org.accountmanagementservice.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manage")
public class AccountManageController {
    @GetMapping("status")
    public String getStatus()
    {
        return "Working";
    }

    @GetMapping("user")
    public User getUser()
    {
        return new User("abcd","shaikh","shahzade","shahzade10@gmail.com");
    }

}
