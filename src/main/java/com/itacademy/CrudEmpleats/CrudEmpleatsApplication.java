package com.itacademy.CrudEmpleats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CrudEmpleatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudEmpleatsApplication.class, args);
	}

}
