package com.example.intern.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "dm_thuoc")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Thuoc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = true)
	private String ten;
	
	private String mota;
	
	//constructor and getter setter
	public Thuoc() {
		// TODO Auto-generated constructor stub
	}

	public Thuoc(Long id, String ten, String mota) {
		super();
		this.id = id;
		this.ten = ten;
		this.mota = mota;
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

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}
}
