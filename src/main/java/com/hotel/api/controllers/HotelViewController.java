package com.hotel.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotelViewController {

    @GetMapping("/hotel")
    public String hotel() {
        return "home"; // home.html
    }
}

