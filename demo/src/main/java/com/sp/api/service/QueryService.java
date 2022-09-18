package com.sp.api.service;

import java.util.List;

import com.sp.api.domain.Query;

public interface QueryService {
	
	List<Query> getQuery();

    Query getQueryById(Long id);

    Query insert(Query Student);


}
