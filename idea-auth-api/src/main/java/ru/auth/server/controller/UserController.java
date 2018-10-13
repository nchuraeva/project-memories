package ru.auth.server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.auth.server.model.User;
import ru.auth.server.model.UserAuthority;
import ru.auth.server.service.AuthorityService;
import ru.auth.server.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {


    private UserService userService;

    private AuthorityService authorityService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Autowired
    public void setAuthorityService(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/login")
    @ResponseBody
    public Map<String,String> getHello() {
        Map<String,String> map = new HashMap<>();
        map.put("str","Login Page");
        return map;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/securied")
    @ResponseBody
    public Map<String,String> getPage() {
        Map<String,String> map = new HashMap<>();
        map.put("str","Secured Page");
        return map;
    }



    @RequestMapping(method = RequestMethod.PUT, value = "/user")
    @ResponseBody
    public Boolean createUser(@RequestBody User user) {
        try {
            userService.register(user);
            authorityService.createAuthority(new UserAuthority(user.getUsername(), "USER"));
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @RequestMapping(method = RequestMethod.GET, value = "/user/{username}")
    @ResponseBody
    public User getUser(@PathVariable String username) {
        try {
            return userService.usernameExists(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

