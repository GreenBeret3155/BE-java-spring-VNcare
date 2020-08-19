package com.example.intern.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dm_khoa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Khoa {
	@Id
	private Long id;
	
	@NotBlank
	private String ten;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cosoyteid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private CoSoYTe cosoyte;
	
	
	//constructor and getter setter
	public Khoa() {
		
	}
	public Khoa(Long id, String ten, CoSoYTe cosoyte) {
		super();
		this.id = id;
		this.ten = ten;
		this.cosoyte = cosoyte;
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
	public CoSoYTe getCosoyte() {
		return cosoyte;
	}
	public void setCosoyte(CoSoYTe cosoyte) {
		this.cosoyte = cosoyte;
	}
	
	
	
}
