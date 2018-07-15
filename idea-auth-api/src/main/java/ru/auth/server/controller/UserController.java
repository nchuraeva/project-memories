package ru.auth.server.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
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

