package com.project.studentManagementSecurityApplication.service;

import com.project.studentManagementSecurityApplication.entity.UserInfo;

import java.util.List;

public interface UserInfoService {


    List<UserInfo> getAllUsers();

    UserInfo getUserById(int userId);


    UserInfo addUser(UserInfo userInfo);
}