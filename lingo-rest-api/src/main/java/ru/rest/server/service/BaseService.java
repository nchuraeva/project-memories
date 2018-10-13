package ru.rest.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.rest.server.model.User;

public class BaseService {

    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }


    public Environment getEnvironment() {
        return environment;
    }

    protected final User getUser(String username) {
        //Отправляем запрос на получение данных по пользаку
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> responseEntity  = restTemplate.getForEntity(environment.getProperty("oauth.serviceUrl")+ "/user/"+username,
                User.class);
        return responseEntity.getBody();
    }
}
