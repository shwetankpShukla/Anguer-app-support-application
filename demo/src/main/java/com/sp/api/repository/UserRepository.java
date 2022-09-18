package com.sp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.api.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUserId(String userId);

}
