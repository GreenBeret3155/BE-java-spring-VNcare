package com.example.intern.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dm_vaitro")
@JsonIgnoreProperties({"id","hibernateLazyInitializer", "handler"})
public class VaiTro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 50)
	private String ten;
	
	@ManyToMany(mappedBy = "roles")
	private Set<TaiKhoan> users;
	
	public VaiTro() {
		// TODO Auto-generated constructor stub
	}

	public VaiTro(Long id, String ten) {
		super();
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

	public Set<TaiKhoan> getUsers() {
		return users;
	}

	public void setUsers(Set<TaiKhoan> users) {
		this.users = users;
	}
}
