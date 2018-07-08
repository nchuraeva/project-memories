package ru.rest.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    @ResponseBody
    public Map<String,String> getHello() {
        Map<String,String> map = new HashMap<>();
        map.put("str","Hello from server!");
        return map;
    }
}
