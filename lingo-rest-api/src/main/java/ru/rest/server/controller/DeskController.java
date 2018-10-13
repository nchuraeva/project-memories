package ru.rest.server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.rest.server.model.Desk;
import ru.rest.server.service.DeskService;

import java.util.List;

@RestController
public class DeskController {

    private DeskService deskService;

    @Autowired
    public void setDeskService(DeskService deskService) {
        this.deskService = deskService;
    }


    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, value = "/desks")
    @ResponseBody
    public List<Desk> getDesks(String username){
        return deskService.getDesks(username);
    }


}
