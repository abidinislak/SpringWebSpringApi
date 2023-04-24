package com.SpringRestApi.SpringRestApi.controller;


import com.SpringRestApi.SpringRestApi.domain.User_Dto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @PostMapping("/save")
    public String test(@RequestBody User_Dto userDto){
        System.err.println(userDto.getName());

        return "test ankara";
    }
}
