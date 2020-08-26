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

import com.example.intern.exception.DuplicateIdException;
import com.example.intern.model.DonThuoc;
import com.example.intern.service.IDonThuocService;

@RestController
@RequestMapping("/api")
public class DonThuocController {
	
	@Autowired
	private IDonThuocService donthuocService;
	
	@GetMapping("/donthuoc")
	public List<DonThuoc> getAll(){
		return donthuocService.getAll();
	}
	
	@GetMapping("/donthuoc/details/{id}")
	public DonThuoc getOneById(@PathVariable("id")Long id) {
		return donthuocService.getOneById(id);
	}
	
	@GetMapping("/dangkykham/{dangkykhamid}/donthuoc")
	public List<DonThuoc> findByDangkykhamId(@PathVariable("dangkykhamid")Long dangkykhamid){
		return donthuocService.findByDangKyKhamId(dangkykhamid);
	}
	
	@PostMapping("/donthuoc/create")
	public DonThuoc createDonThuoc (@Valid @RequestBody DonThuoc donthuoc) {
		if(donthuoc.getId() == null) return donthuocService.save(donthuoc);
		DonThuoc donthuoc2 = donthuocService.getOneById(donthuoc.getId());
		if(donthuoc2 != null) throw new DuplicateIdException("DonThuoc", donthuoc.getId());
		
		return donthuocService.save(donthuoc);
	}
	
	@PutMapping("/donthuoc/update/{id}")
	public DonThuoc updateDonThuoc (@PathVariable("id")Long id,
			@Valid @RequestBody DonThuoc donthuocRequest) {
		DonThuoc donthuoc = donthuocService.getOneById(id);
		donthuoc.setSoluong(donthuocRequest.getSoluong());
		donthuoc.setHuongdan(donthuocRequest.getHuongdan());
		donthuoc.setDangkykham(donthuocRequest.getDangkykham());
		donthuoc.setDonvitinh(donthuocRequest.getDonvitinh());
		donthuoc.setThuoc(donthuocRequest.getThuoc());
		
		return donthuocService.save(donthuocRequest);
	}
	
	@DeleteMapping("/donthuoc/delete/{id}")
	public ResponseEntity<?> deleteDonThuoc(@PathVariable("id")Long id) {
		donthuocService.deleteByDangkykhamId(id);
		return ResponseEntity.ok().build();
	}
	
	
//	@DeleteMapping("/dangkykham/{dangkykhamid}/donthuoc")
//	public ResponseEntity<?> deleteDonThuocByDangkykhamId(@PathVariable("dangkykhamid")Long dangkykhamid) {
//		donthuocService.deleteByDangkykhamId(dangkykhamid);
//		return ResponseEntity.ok().build();
//	}
	
}
