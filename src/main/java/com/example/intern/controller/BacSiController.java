package com.example.intern.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intern.model.BacSi;
import com.example.intern.model.Khoa;
import com.example.intern.model.TaiKhoan;
import com.example.intern.service.IBacSiService;
import com.example.intern.service.IKhoaService;
import com.example.intern.service.ITaiKhoanService;

@RestController
@RequestMapping("/api")
public class BacSiController {
	
	@Autowired 
	private IBacSiService bacsiService;
	
	@Autowired
	private IKhoaService khoaService;
	
	@Autowired
	private ITaiKhoanService taikhoanService;
	
	@GetMapping("/bacsi")
	public List<BacSi> getAll(){
		return bacsiService.getAll();
	}
	
	@GetMapping("/bacsi/{id}")
	public BacSi getOneById(@PathVariable("id") Long id) {
		return bacsiService.getOneById(id);
	}
	
	@GetMapping("/bacsi/khoa/{khoaid}")
	public List<BacSi> findByKhoaId(@PathVariable("khoaid") Long khoaid){
		return bacsiService.findByKhoaId(khoaid);
	}
	
	@GetMapping("/bacsi/taikhoan/{taikhoanid}")
	public BacSi findByTaikhoanId(@PathVariable("taikhoanid") Long taikhoanid){
		return bacsiService.findByTaikhoanId(taikhoanid);
	}
	
	@PostMapping("/bacsi/khoa/{khoaid}/taikhoan/{taikhoanid}")
	public BacSi createBacSi(@PathVariable("khoaid") Long khoaid,
			@PathVariable("taikhoanid") Long taikhoanid,
			@Valid @RequestBody BacSi bacsiRequest) {
		Khoa khoa = khoaService.getOneById(khoaid);
		TaiKhoan taikhoan = taikhoanService.getOneById(taikhoanid);
		
		bacsiRequest.setKhoa(khoa);
		bacsiRequest.setTaikhoan(taikhoan);
		return bacsiService.save(bacsiRequest);
	}
	
	@PutMapping("/bacsi/{bacsiid}/khoa/{khoaid}/taikhoan/{taikhoanid}")
	public BacSi updateBacSi(@PathVariable("bacsiid") Long bacsiid,
			@PathVariable("khoaid") Long khoaid,
			@PathVariable("taikhoanid") Long taikhoanid,
			@Valid @RequestBody BacSi bacsiRequest) {
		Khoa khoa = khoaService.getOneById(khoaid);
		BacSi bacsi = bacsiService.getOneById(bacsiid);
		TaiKhoan taikhoan = taikhoanService.getOneById(taikhoanid);
		
		bacsi.setTen(bacsiRequest.getTen());
		bacsi.setChuyenkhoa(bacsiRequest.getChuyenkhoa());
		bacsi.setTrinhdo(bacsiRequest.getTrinhdo());
		bacsi.setMota(bacsiRequest.getMota());
		bacsi.setKhoa(khoa);
		bacsi.setTaikhoan(taikhoan);
		
		return bacsiService.save(bacsi);
	}
	
	@DeleteMapping("/bacsi/{id}")
	public ResponseEntity<?> deleteBacSi(@PathVariable("id") Long id) {
		bacsiService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}



























