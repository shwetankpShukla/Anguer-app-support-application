package com.sp.api.laoder;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sp.api.domain.Student;
import com.sp.api.repository.StudentRepositry;

@Component
public class StudentLoader implements CommandLineRunner {
	
	@Autowired
	StudentRepositry repo;

	@Override
	public void run(String... args) throws Exception {
		loadStudent();
	}

	private void loadStudent() {
		if (repo.count() == 0) {
            repo.save(
                    Student.builder()
                            .Name("Student1").address("Sample Address")
                            .state("2").email("sample@gmail.com").dob(ZonedDateTime.now().minusYears(20))
                            .build()
            );
            repo.save(
            		 Student.builder()
                     .Name("Student2").address("Sample Address 2")
                     .state("1").email("sample2@gmail.com").dob(ZonedDateTime.now().minusYears(20))
                     .build()
            );
            System.out.println("Sample Students Loaded");
        }
		
	}

}
