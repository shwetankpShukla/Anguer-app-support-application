package com.sp.api.domain;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor

@Builder
public class Student {
	
	
	@Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;
    @Column
    String Name;
    
    @Column
    String address;
    
    
    @Column
    ZonedDateTime dob;
    
    @Column
    String email;
    
    @Column
    String state;
    
    @Column
    String description;
    
    @Column
    String todoStatus;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dateCreated;
    
    @UpdateTimestamp
    Timestamp lastModified;

}
