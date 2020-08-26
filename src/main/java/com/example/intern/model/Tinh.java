package com.example.intern.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="dm_tinh")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tinh {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	@Size(max = 30)
	private String ten;
	
	
	//constructor and getter setter 
	public Tinh() {
		
	}
	
	public Tinh(Long id, String ten, String mota) {
		this.id = id;
		this.ten = ten;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
}

