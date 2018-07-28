package ru.auth.server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

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


}

