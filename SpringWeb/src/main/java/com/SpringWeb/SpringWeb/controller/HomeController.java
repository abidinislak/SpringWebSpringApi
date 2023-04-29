package com.SpringWeb.SpringWeb.controller;


import com.SpringWeb.SpringWeb.dto.User_Dto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {


    @Value("${asd}")
    private String value;

    @GetMapping("/home")
    public String home(Model model) {
        ObjectMapper mapper = new ObjectMapper();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:8081/findAll", Object[].class);
        Object[] objects = responseEntity.getBody();

        List<User_Dto> list = Arrays.stream(objects).map(object -> mapper.convertValue(object, User_Dto.class)).collect(Collectors.toList());


        User_Dto etst = new User_Dto();
        etst.setName("asd");


        model.addAttribute("user", etst);
        model.addAttribute("asd", value);
        model.addAttribute("list", list);

        return "home";


    }


    @GetMapping("/jquery")
    public String jquery() {


        return "jquery";
    }

    @PostMapping("/save")
    public RedirectView saveUSer(User_Dto user_dto, RedirectAttributes redirectAttributes) throws URISyntaxException {


        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("http://localhost:8081/save");

        ResponseEntity<User_Dto> result = restTemplate.postForEntity(uri, user_dto, User_Dto.class);

        if (result.getStatusCode() == HttpStatus.OK)
            redirectAttributes.addFlashAttribute("message", "Etiy Saved with id " + result.getBody().getId());


        else {

            redirectAttributes.addFlashAttribute("message", "Error has been detected ");


        }
        return new RedirectView("/home");
    }


}



