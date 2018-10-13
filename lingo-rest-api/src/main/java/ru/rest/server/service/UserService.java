package ru.rest.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.rest.server.bean.NewUserInfo;
import ru.rest.server.bean.Response;
import ru.rest.server.model.User;

@Service
public class UserService extends BaseService {

    private DeskService deskService;

    @Autowired
    public void setDeskService(DeskService deskService) {
        this.deskService = deskService;
    }

    public Response<Boolean> registerNewUser(NewUserInfo info, HttpHeaders headers) {
        try {

            User user = getUser(info.getUsername());
            if (user != null) {
                return new Response<>(Boolean.FALSE, "Пользователь с таким именем уже существует!");
            }
            user = new User();
            user.setPassword(new BCryptPasswordEncoder().encode(info.getPassword()));
            user.setUsername(info.getUsername());
            user.setEmail(info.getEmail());

            //добавляем авторизационный сервис
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<User> request = new HttpEntity<>(user, headers);

            restTemplate.put(getEnvironment().getProperty("oauth.serviceUrl") + "/user", request);

            this.createDefaultDesks(info.getUsername());

            return new Response<>(Boolean.TRUE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createDefaultDesks(String username) {
        deskService.createDefaultDesks(username);
    }


}
