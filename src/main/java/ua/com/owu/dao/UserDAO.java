package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ua.com.owu.entity.User;

/**
 * Created by User on 22.06.2017.
 */

public interface UserDAO extends JpaRepository<User, Integer> , JpaSpecificationExecutor<User>{

    User findByUsername(String username);

    @Query("select distinct u from User u where u.email=?1 ")
    User findUniqueEmail(String email);
}
