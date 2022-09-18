package com.sp.api.laoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sp.api.domain.Query;
import com.sp.api.repository.QueryRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class QueryLoader implements CommandLineRunner {
	
	@Autowired
	private QueryRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		loadQuery();
	}
	
	

	private void loadQuery() {
		if(repository.count()==0) {
			repository.save(Query.builder()
					.id(1L)
					.firstName("Shwetank")
					.lastname("Shukla")
					.email("shwetank@gamil.com")
					.mobile("9918303218")
					.state("2")
					.subject("this is sample text").build());			
		}
		log.info("query added.. ");
		System.out.println("query added.. ");
		
	}

}
