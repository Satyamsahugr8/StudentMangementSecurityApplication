package com.project.studentManagementSecurityApplication.controller;

import com.project.studentManagementSecurityApplication.entity.UserInfo;
import com.project.studentManagementSecurityApplication.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserInfoController {

    @Autowired
    private UserInfoService userService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo){
        userService.addUser(userInfo);
        return "User added successfully";
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserInfo> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public UserInfo getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

}
