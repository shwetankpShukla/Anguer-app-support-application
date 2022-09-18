package com.sp.api.service;

import java.util.List;

import com.sp.api.domain.Student;

public interface StudentService {
	
	List<Student> getStudents();

    Student getStudentById(Long id);

    Student insert(Student Student);

    void updateStudent(Long id, Student Student);

    void deleteStudent(Long StudentId);

}
