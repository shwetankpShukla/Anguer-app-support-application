package com.sp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.api.domain.Query;


public interface QueryRepository extends JpaRepository<Query, Long> {

}
