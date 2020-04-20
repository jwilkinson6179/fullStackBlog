package com.zipcode.fullstackblog.controllers;

import com.zipcode.fullstackblog.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private static UserService serv;

    @Autowired
    public UserController(UserService ser) {
        serv = ser;
    }

    public static UserService getServ() {
        return serv;
    }



}
