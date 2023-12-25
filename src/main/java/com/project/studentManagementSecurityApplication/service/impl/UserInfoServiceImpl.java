package com.project.studentManagementSecurityApplication.service.impl;

import com.project.studentManagementSecurityApplication.repository.UserInfoRepository;
import com.project.studentManagementSecurityApplication.service.UserInfoService;
import com.project.studentManagementSecurityApplication.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserInfoServiceImpl(UserInfoRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserInfo> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserInfo getUserById(int userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public UserInfo addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return userRepository.save(userInfo);
    }


}
