package com.gqlxc.service;

import com.gqlxc.domain.User;

public interface UserSercvice {
    User checkUser(String name, String password);
}
