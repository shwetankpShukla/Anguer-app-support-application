package com.sp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sp.api.domain.Query;
import com.sp.api.service.QueryService;

@Repository
@RequestMapping("/api/v1/query")
@CrossOrigin
public class QueryController {
	
	@Autowired
	private QueryService service;
	
	@GetMapping
    public ResponseEntity<List<Query>> getAllQuery() {
        List<Query> querys = service.getQuery();
        return new ResponseEntity<>(querys, HttpStatus.OK);
    }
    //The function receives a GET request, processes it, and gives back a list of Student as a response.
    @GetMapping({"/{queryId}" ,})
    public ResponseEntity<Query> getQuery(@PathVariable Long queryId) {
        return new ResponseEntity<>(service.getQueryById(queryId), HttpStatus.OK);
    }
    //The function receives a POST request, processes it, creates a new Student and saves it to the database, and returns a resource link to the created Student.           @PostMapping
    
    @PostMapping(value="/",produces = "application/json")
    public ResponseEntity<Query> saveQuery(@RequestBody Query query) {
    	query = service.insert(query);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Student", "/api/v1/query/" + query.getId().toString());
        return new ResponseEntity<>(query, httpHeaders, HttpStatus.CREATED);
    }

}
