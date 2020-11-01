package com.gqlxc.service;

import com.gqlxc.dao.UserRepository;
import com.gqlxc.domain.User;
import com.gqlxc.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserSercvice{

    @Autowired
    UserRepository userRepository;

    @Override
    public User checkUser(String name, String password) {

        User user = userRepository.findByUsernameAndPassword(name, MD5Utils.stringToMD5(password));

        return user;
    }
}
