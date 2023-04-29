package com.SpringRestApi.SpringRestApi;

import com.SpringRestApi.SpringRestApi.entity.User_D;
import com.SpringRestApi.SpringRestApi.repository.USerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.swing.text.html.parser.DTD;
import java.util.Arrays;

@SpringBootApplication
public class SpringRestApiApplication implements CommandLineRunner {




	@Autowired
	USerRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Arrays.asList(new User_D("asda","sadas"),new User_D("asda","sadas"),new User_D("asda","sadas"),new User_D("asda","sadas"))
				.stream().forEach(x->userRepository.save(x));

	}
}
