package com.sp.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="query_mtb")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Query {
	
	@Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;
    
    private String firstName;
    private String lastname;
    private String email;
    private String mobile;
    private String state;
    private String subject;

}
