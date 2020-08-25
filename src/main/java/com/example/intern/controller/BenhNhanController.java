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

import com.example.intern.model.BenhNhan;
import com.example.intern.model.TaiKhoan;
import com.example.intern.service.IBenhNhanService;
import com.example.intern.service.ITaiKhoanService;

@RestController
@RequestMapping("/api")
public class BenhNhanController {
	
	@Autowired
	private IBenhNhanService benhnhanService;
	
	@Autowired
	private ITaiKhoanService taikhoanService;
	
	@GetMapping("/benhnhan")
	public List<BenhNhan> getAll(){
		return benhnhanService.getAll();
	}
	
	@GetMapping("/benhnhan/{id}")
	public BenhNhan getOneById(@PathVariable("id") Long id) {
		return benhnhanService.getOneById(id);
	}
	
	@GetMapping("/taikhoan/{taikhoanid}/benhnhan")
	public BenhNhan findByTaikhoanId(@PathVariable("taikhoanid") Long taikhoanid ) {
		return benhnhanService.findByTaikhoanId(taikhoanid);
	}
	
	@PostMapping("/taikhoan/{taikhoanid}/benhnhan")
	public BenhNhan createBenhNhan(@PathVariable("taikhoanid") Long taikhoanid, 
			@Valid @RequestBody BenhNhan benhnhanRequest) {
		TaiKhoan taikhoan = taikhoanService.getOneById(taikhoanid);
		benhnhanRequest.setTaikhoan(taikhoan);
		
		return benhnhanService.save(benhnhanRequest);
	}
	
	@PostMapping("/benhnhan")
	public BenhNhan createBenhNhanWithoutTaikhoanId(@Valid @RequestBody BenhNhan benhnhan) {
		return benhnhanService.save(benhnhan);
	}
	
//	@PutMapping("/taikhoan/{taikhoanid}/benhnhan/{id}")
//	public BenhNhan updateBenhNhan(@PathVariable("id")Long id,
//			@PathVariable("taikhoanid") Long taikhoanid,
//			@Valid @RequestBody BenhNhan benhnhanRequest) {
//		TaiKhoan taikhoan = taikhoanService.getOneById(taikhoanid);
//		BenhNhan benhnhan = benhnhanService.getOneById(id);
//		
//		benhnhan.setTen(benhnhanRequest.getTen());
//		benhnhan.setNgaysinh(benhnhanRequest.getNgaysinh());
//		benhnhan.setGioitinh(benhnhanRequest.getGioitinh());
//		benhnhan.setCmnd(benhnhanRequest.getCmnd());
//		benhnhan.setNgaycap(benhnhanRequest.getNgaycap());
//		benhnhan.setNoicap(benhnhanRequest.getNoicap());
//		benhnhan.setBhyt(benhnhanRequest.getBhyt());
//		benhnhan.setDiachi(benhnhanRequest.getDiachi());
//		benhnhan.setTaikhoan(taikhoan);
//		
//		return benhnhanService.save(benhnhan);
//	}
	
	@PutMapping("/benhnhan/{id}")
	public BenhNhan updateBenhNhanWithoutTaikhoanId(@PathVariable("id")Long id,
			@Valid @RequestBody BenhNhan benhnhanRequest) {
		BenhNhan benhnhan = benhnhanService.getOneById(id);
		
		benhnhan.setTen(benhnhanRequest.getTen());
		benhnhan.setNgaysinh(benhnhanRequest.getNgaysinh());
		benhnhan.setGioitinh(benhnhanRequest.getGioitinh());
		benhnhan.setCmnd(benhnhanRequest.getCmnd());
		benhnhan.setNgaycap(benhnhanRequest.getNgaycap());
		benhnhan.setNoicap(benhnhanRequest.getNoicap());
		benhnhan.setBhyt(benhnhanRequest.getBhyt());
		benhnhan.setDiachi(benhnhanRequest.getDiachi());
		
		return benhnhanService.save(benhnhan);
	}
	
	@DeleteMapping("/benhnhan/{id}")
	public ResponseEntity<?> deleteBenhNhan(@PathVariable("id") Long id) {
		benhnhanService.delete(id);
		return ResponseEntity.ok().build();
	}
}


