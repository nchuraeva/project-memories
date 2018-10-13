package ru.auth.server.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.auth.server.model.User;
import ru.auth.server.model.UserAuthority;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserAuthorityRepository {


    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private final String CREATE_AUTHORITY = "insert into user_authority (username, authority) values (:username, :authority)";


    public void save(UserAuthority userAuthority) {
        Map namedParameters = new HashMap();
        namedParameters.put("username", userAuthority.getUsername());
        namedParameters.put("authority", userAuthority.getAuthority());
        jdbcTemplate.update(CREATE_AUTHORITY, namedParameters);

    }
}
