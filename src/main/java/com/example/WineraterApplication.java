package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.SQLException;

@SpringBootApplication
public class WineraterApplication {

    public static void main(String[] args)throws SQLException {
		SpringApplication.run(WineraterApplication.class, args);
	}
}

