package ru.rest.server.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class HelloController {


    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, value = "/home")
    @ResponseBody
    public Map<String,String> getHello() {
        Map<String,String> map = new HashMap<>();
        map.put("str","Hello from server!");
        return map;
    }
}
