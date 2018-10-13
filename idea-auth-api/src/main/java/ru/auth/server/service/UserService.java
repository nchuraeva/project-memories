package ru.auth.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import ru.auth.server.model.User;
import ru.auth.server.model.mapper.UserMapper;
import ru.auth.server.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    private final String FIND_BY_USERNAME = "select * from user where username = :username";
    private final String CREATE_USER = "insert into account (username, password, email) values (:username, :password, :email, true)";


    public void  register(User user) {
        this.userRepository.save(user);
    }

    public User usernameExists(String username) {
      return userRepository.findByUsername(username);
    }
}
