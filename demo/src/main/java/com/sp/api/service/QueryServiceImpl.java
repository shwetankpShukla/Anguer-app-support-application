package com.sp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.api.domain.Query;
import com.sp.api.repository.QueryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QueryServiceImpl implements QueryService {
	
	@Autowired
	private QueryRepository repository;

	@Override
	public List<Query> getQuery() {
		log.info("QueryServiceImpl>getQuery");
		return  repository.findAll();
	}

	@Override
	public Query getQueryById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Query insert(Query query) {
		return repository.save(query);
	}

}
