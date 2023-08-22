package com.org.accountmanagementservice.Controller;

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

}
