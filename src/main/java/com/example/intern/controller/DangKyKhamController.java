package com.example.intern.controller;

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

import com.example.intern.exception.DuplicateIdException;
import com.example.intern.model.DangKyKham;
import com.example.intern.service.IDangKyKhamService;

@RestController
@RequestMapping("/api")
public class DangKyKhamController {
	
	@Autowired
	private IDangKyKhamService dangkykhamService;
	
	@GetMapping("/dangkykham/details/{id}")
	public DangKyKham getOneById(@PathVariable("id")Long id) {
		return dangkykhamService.getOneById(id);
	}
	
	@PostMapping("/dangkykham/create")
	public DangKyKham createDangKyKham(@Valid @RequestBody DangKyKham dangkykham) {
		if(dangkykham.getId() == null) return dangkykhamService.save(dangkykham);
		DangKyKham dangkykham2 = dangkykhamService.getOneById(dangkykham.getId());
		if(dangkykham2 != null) throw new DuplicateIdException("DangKyKham", dangkykham.getId());

		return dangkykhamService.save(dangkykham);
	}
	
	
	@PutMapping("/dangkykham/update/{id}")
	public DangKyKham createDangKyKham(@PathVariable("id")Long id,
			@Valid @RequestBody DangKyKham dangkykhamRequest) {
		DangKyKham dangkykham = dangkykhamService.getOneById(id);
		
		dangkykham.setThoigiandk(dangkykhamRequest.getThoigiandk());
		dangkykham.setThoigiankham(dangkykhamRequest.getThoigiankham());
		dangkykham.setTrangthaikham(dangkykhamRequest.isTrangthaikham());
		dangkykham.setNoidungkham(dangkykhamRequest.getNoidungkham());
		dangkykham.setLoaikham(dangkykhamRequest.getLoaikham());
		dangkykham.setBenhphu(dangkykhamRequest.getBenhphu());
		dangkykham.setMota(dangkykhamRequest.getMota());
		dangkykham.setBacsi(dangkykhamRequest.getBacsi());
		dangkykham.setBenhnhan(dangkykhamRequest.getBenhnhan());
		dangkykham.setBenh(dangkykhamRequest.getBenh());
		
		return dangkykhamService.save(dangkykham);
	}
	
	@DeleteMapping("/dangkykham/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")Long id) {
		dangkykhamService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}	





























