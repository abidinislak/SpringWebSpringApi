package com.SpringWeb.SpringWeb.controller;


import com.SpringWeb.SpringWeb.dto.User_Dto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Controller
public class HomeController {

    @Value("${asd}")
    private String value;

    @GetMapping("/home")
    public String home(Model model) {


        User_Dto etst = new User_Dto();
        etst.setName("asd");

        model.addAttribute("user", etst);
        model.addAttribute("asd", value);

        return "home";

    }


    @PostMapping("/save")
    public String saveUSer(User_Dto user_dto) throws URISyntaxException {

        try {


            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("http://localhost:8081/save");

            ResponseEntity<User_Dto> result = restTemplate.postForEntity(uri, user_dto, User_Dto.class);

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }

        return null;
    }


}



