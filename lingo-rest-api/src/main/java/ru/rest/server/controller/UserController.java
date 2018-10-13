package ru.rest.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rest.server.bean.NewUserInfo;
import ru.rest.server.bean.Response;
import ru.rest.server.service.UserService;


@Controller
public class UserController  {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/register")
    @ResponseBody
    public Response<Boolean> registerNewUser(@RequestBody NewUserInfo userInfo, @RequestHeader HttpHeaders headers) {
        return this.userService.registerNewUser(userInfo, headers);
    }

}
