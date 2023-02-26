package com.example.Security2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class Security2Application implements CommandLineRunner {

	@Autowired
	MyUserRepository myUserRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Security2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		MyUser user1 = MyUser.builder()
				.username("Sai")
				.password(passwordEncoder.encode("sai123"))
				.authority("dev")
				.build();

		MyUser user2 = MyUser.builder()
				.username("Rahul")
				.password(passwordEncoder.encode("rahul123"))
				.authority("qa")
				.build();

		myUserRepository.saveAll(Arrays.asList(user1, user2));
	}
}
