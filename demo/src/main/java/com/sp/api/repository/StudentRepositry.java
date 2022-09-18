package com.sp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.api.domain.Student;

public interface StudentRepositry extends JpaRepository<Student, Long> {

}
