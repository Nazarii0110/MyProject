package ua.com.owu.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.com.owu.entity.User;

import java.util.List;


public interface UserService extends UserDetailsService{

    void  save(User user);

    List<User> findAllUsers();
    User findUniqueEmail(String email);
}
