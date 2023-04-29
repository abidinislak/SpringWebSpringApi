package com.SpringRestApi.SpringRestApi.controller;


import com.SpringRestApi.SpringRestApi.domain.User_Dto;
import com.SpringRestApi.SpringRestApi.entity.User_D;
import com.SpringRestApi.SpringRestApi.repository.USerRepository;
import com.SpringRestApi.SpringRestApi.util.UserDtoList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class HomeController {

    @Autowired
    ModelMapper modelMapper;


    @Autowired
    USerRepository repository;
    @PostMapping("/save")
    public ResponseEntity<User_Dto> test(@RequestBody User_Dto userDto){


        User_D entity=modelMapper.map(userDto,User_D.class);

        User_D result=repository.save(entity);
        User_Dto returnResult;
        if(result !=null)
        {
             returnResult=modelMapper.map(result,User_Dto.class);
        }

        else returnResult=new User_Dto();




        return ResponseEntity.status(HttpStatus.CREATED).body(returnResult);
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<User_Dto>> findAll(){

        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll().stream().map(x->modelMapper.map(x,User_Dto.class)).toList());
    }


    @GetMapping("/testrest")
    public ResponseEntity<String> test(){

        return ResponseEntity.status(HttpStatus.OK).body("succes fule return rest api");

    }
    @GetMapping("/fetchTable")
    public UserDtoList fetchTable(){


List<User_D> list=repository.findAll();

        UserDtoList object=new UserDtoList();
object.setList(list.stream().map(x->modelMapper.map(x,User_Dto.class)).toList());


        return object;

    }
}
