package com.sp.api.laoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sp.api.domain.User;
import com.sp.api.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserLoader implements CommandLineRunner {
	
	@Autowired
	UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		loadUser();
	}

	private void loadUser() {
		if(repository.count()==0) {
			repository.save(User.builder()
					.id(1L).userId("kalyan").password("Password12").build());
			repository.save(User.builder()
					.id(1L).userId("oviya").password("Password12").build());
			repository.save(User.builder()
					.id(1L).userId("manhohar").password("Password12").build());
			repository.save(User.builder()
					.id(1L).userId("neha").password("Password12").build());
			repository.save(User.builder()
					.id(1L).userId("thiru").password("Password12").build());
			repository.save(User.builder()
					.id(1L).userId("naveen").password("Password12").build());
		}
		
		log.info("user addeed kalyan , oviya , neha , manohar, thiru, naveen");
		
	}

}
