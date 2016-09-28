package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@Controller
@SpringBootApplication
public class WineraterApplication {
//
//	@GetMapping("/")
//    public ModelAndView init(){
//        ModelAndView modelAndView = new ModelAndView("index");
//        return modelAndView;
//    }
    public static void main(String[] args)throws SQLException {
		SpringApplication.run(WineraterApplication.class, args);
	}
}

