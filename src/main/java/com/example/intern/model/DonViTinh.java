package com.example.intern.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dm_donvitinh")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DonViTinh {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String ten;
	
	private String chitiet;
	
	
	//constructor and getter setter
	public DonViTinh() {
		// TODO Auto-generated constructor stub
	}

	public DonViTinh(Long id, String ten, String chitiet) {
		super();
		this.id = id;
		this.ten = ten;
		this.chitiet = chitiet;
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

	public String getChitiet() {
		return chitiet;
	}

	public void setChitiet(String chitiet) {
		this.chitiet = chitiet;
	}
	
}