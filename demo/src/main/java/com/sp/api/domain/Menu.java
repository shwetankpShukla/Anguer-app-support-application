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

@Table(name="menu_mtb")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
	
	@Id
    @Column(updatable = false, nullable = false)
    private String menuId;
	
	private String menuName;
	
	private String menuImg;
	
	private String menuUrl;

}
