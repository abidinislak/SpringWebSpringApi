package com.SpringWeb.SpringWeb.controller;

import com.SpringWeb.SpringWeb.dto.User_Dto;
import com.SpringWeb.SpringWeb.util.UserDtoList;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RestHomeController {


    @GetMapping("/userList")
    public ResponseEntity<List<User_Dto>> getUserList() {

        return null;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String test() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8081/testrest", String.class);
        String objects = responseEntity.getBody();


        return responseEntity.getBody();
    }

    @RequestMapping(value = "/fetchTable", method = RequestMethod.GET)
    public List<User_Dto> fetchTable() {


        try {
            RestTemplate restTemplate = new RestTemplate();
            var responseEntity = restTemplate.getForObject("http://localhost:8081/fetchTable", UserDtoList.class);
            List<User_Dto> list = responseEntity.getList();

            return list;

        } catch (Exception exception) {

            System.err.println(exception.getMessage());
        }
        return null;
    }


}
