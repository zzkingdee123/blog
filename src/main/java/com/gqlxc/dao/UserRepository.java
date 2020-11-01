package com.gqlxc.dao;

import com.gqlxc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
        User findByUsernameAndPassword(String username,String password);
}
