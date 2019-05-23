package com.sajam.springboot;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.sajam.springboot.DAO.KorisniciDAO;

import com.sajam.springboot.entiteti.Korisnici;

@SpringBootApplication
@EnableJpaAuditing
@EnableAutoConfiguration


public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class,args);
		
	}

}
