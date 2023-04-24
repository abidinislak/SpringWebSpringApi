package com.SpringWeb.SpringWeb.controller;

import com.SpringWeb.SpringWeb.dto.User_Dto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestHomeController {


    @GetMapping("/userList")
    public ResponseEntity<List<User_Dto>> getUserList() {

        return null;
    }


}
