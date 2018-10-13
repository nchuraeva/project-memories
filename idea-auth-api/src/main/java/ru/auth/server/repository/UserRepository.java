package ru.auth.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.auth.server.model.User;
import ru.auth.server.model.mapper.UserMapper;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private final String FIND_BY_USERNAME = "select * from users where username = :username";
    private final String CREATE_USER = "insert into users (username, password, activated,  email) values (:username, :password, :activated, :email)";


    public void save(User user) {
        Map namedParameters = new HashMap();
        namedParameters.put("username", user.getUsername());
        namedParameters.put("password", user.getPassword());
        namedParameters.put("email", user.getEmail());
        namedParameters.put("activated", true);
        jdbcTemplate.update(CREATE_USER, namedParameters);

    }

    public User findByUsername(String username) {
         try {
            SqlParameterSource namedParameters = new MapSqlParameterSource("username", username);
            User user = (User) jdbcTemplate.queryForObject(FIND_BY_USERNAME, namedParameters, new UserMapper());
            return user;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
