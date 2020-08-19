package com.example.intern.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dm_benhnhan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BenhNhan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotBlank
	private String ten ;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull
	private Date ngaysinh;
	
	@NotBlank
	private String gioitinh;
	
	private String cmnd;
	
	private Date ngaycap;
	
	private String noicap;
	
	private String bhyt;
	
	@NotBlank
	private String diachi;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "taikhoanid", nullable = true )
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private TaiKhoan taikhoan;
	
	
	//constructor and getter setter
	public BenhNhan() {
		// TODO Auto-generated constructor stub
	}

	public BenhNhan(Long id, String ten, Date ngaysinh, String gioitinh, String cmnd, Date ngaycap, String noicap,
			String bhyt, String diachi, TaiKhoan taikhoan) {
		super();
		this.id = id;
		this.ten = ten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.cmnd = cmnd;
		this.ngaycap = ngaycap;
		this.noicap = noicap;
		this.bhyt = bhyt;
		this.diachi = diachi;
		this.taikhoan = taikhoan;
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

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public Date getNgaycap() {
		return ngaycap;
	}

	public void setNgaycap(Date ngaycap) {
		this.ngaycap = ngaycap;
	}

	public String getNoicap() {
		return noicap;
	}

	public void setNoicap(String noicap) {
		this.noicap = noicap;
	}

	public String getBhyt() {
		return bhyt;
	}

	public void setBhyt(String bhyt) {
		this.bhyt = bhyt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}
}
