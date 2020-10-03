package com.example.intern.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="dm_taikhoan")
@JsonIgnoreProperties({"username","password","sdt","hoten","hibernateLazyInitializer", "handler"})
public class TaiKhoan implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 50)
	private String username;
	
	@NotNull
	@Size(max = 60)
	private String password;
	
	@NotNull
	@Size(max = 20)
	private String sdt;
	
	@Size(max = 50)
	private String hoten;
	
	@ManyToMany(fetch = FetchType.EAGER )
    @JoinTable(
            name = "dm_taikhoan_vaitro",
            joinColumns = @JoinColumn(name = "taikhoanid", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "vaitroid", nullable = false)
    )
    private Set<VaiTro> roles;
	
	
	//constructor and getter setter
	public TaiKhoan() {
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(Long id, String username, String password, String sdt, String hoten) {
		super();
		this.id = id;
		this.username = username;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Set<VaiTro> getRoles() {
		return roles;
	}

	public void setRoles(Set<VaiTro> roles) {
		this.roles = roles;
	}
}
