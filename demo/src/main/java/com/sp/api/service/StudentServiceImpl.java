package com.sp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.api.domain.Student;
import com.sp.api.repository.StudentRepositry;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepositry repositry;

	@Override
	public List<Student> getStudents() {
		return repositry.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		 return repositry.findById(id).get();
	}

	@Override
	public Student insert(Student student) {
		 return repositry.save(student);
	}

	@Override
	public void updateStudent(Long id, Student student) {
		 Student studentFromDb = repositry.findById(id).get();
	        System.out.println(studentFromDb.toString());
	     studentFromDb.setName(student.getName());
	     studentFromDb.setAddress(student.getAddress());
	     studentFromDb.setState(student.getState());
	     studentFromDb.setEmail(student.getEmail());
	     studentFromDb.setEmail(student.getEmail());
	     studentFromDb.setDob(student.getDob());
	     repositry.save(studentFromDb);

	}

	@Override
	public void deleteStudent(Long studentId) {
		repositry.deleteById(studentId);

	}

}
