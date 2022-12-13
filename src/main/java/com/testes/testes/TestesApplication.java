package com.testes.testes;

import com.testes.testes.Repository.userRespository;
import com.testes.testes.domain.user;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestesApplication.class, args);
	}

	@Autowired
	private userRespository userRespository;

	@Override
	public void run(String... args) throws Exception {

		user user1 = new user(null, "wesley", "180320");

		userRespository.save(user1);

	}
}
