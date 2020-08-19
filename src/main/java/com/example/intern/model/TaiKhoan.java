package com.example.intern.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="dm_taikhoan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TaiKhoan {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String sdt;
	
	private String hoten;
	
	
	//constructor and getter setter
	public TaiKhoan() {
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(Long id, String email, String password, String sdt, String hoten) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.sdt = sdt;
		this.hoten = hoten;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
}
