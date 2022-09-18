package com.sp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.api.domain.Student;
import com.sp.api.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
@CrossOrigin
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	//The function receives a GET request, processes it and gives back a list of Student as a response.
	
	@GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> Students = service.getStudents();
        return new ResponseEntity<>(Students, HttpStatus.OK);
    }
    //The function receives a GET request, processes it, and gives back a list of Student as a response.
    @GetMapping({"/{StudentId}" ,})
    public ResponseEntity<Student> getStudent(@PathVariable Long StudentId) {
        return new ResponseEntity<>(service.getStudentById(StudentId), HttpStatus.OK);
    }
    //The function receives a POST request, processes it, creates a new Student and saves it to the database, and returns a resource link to the created Student.           @PostMapping
    
    @PostMapping(value="/",produces = "application/json")
    public ResponseEntity<Student> saveStudent(@RequestBody Student Student) {
        Student Student1 = service.insert(Student);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Student", "/api/v1/Student/" + Student1.getId().toString());
        return new ResponseEntity<>(Student1, httpHeaders, HttpStatus.CREATED);
    }
    //The function receives a PUT request, updates the Student with the specified Id and returns the updated Student
    @PutMapping({"/{StudentId}"})
    public ResponseEntity<Student> updateStudent(@PathVariable("StudentId") Long StudentId, @RequestBody Student Student) {
        service.updateStudent(StudentId, Student);
        return new ResponseEntity<>(service.getStudentById(StudentId), HttpStatus.OK);
    }
    //The function receives a DELETE request, deletes the Student with the specified Id.
    @DeleteMapping({"/{StudentId}"})
    public ResponseEntity<Student> deleteStudent(@PathVariable("StudentId") Long StudentId) {
        service.deleteStudent(StudentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
