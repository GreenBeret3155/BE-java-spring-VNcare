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
import com.example.intern.model.DonViTinh;
import com.example.intern.service.IDonViTinhService;

@RestController
@RequestMapping("/api")
public class DonViTinhController {
	
	@Autowired
	private IDonViTinhService donvitinhService;
	
	@GetMapping("/donvitinh")
	public List<DonViTinh> getAll(){
		return donvitinhService.getAll();
	}
	
	@GetMapping("/donvitinh/details/{id}")
	public DonViTinh getOneById(@PathVariable("id") Long id) {
		return donvitinhService.getOneById(id);
	}
	
	@PostMapping("/donvitinh/create")
	public DonViTinh createDonViTinh(@Valid @RequestBody DonViTinh donvitinh) {
		if(donvitinh.getId() == null) return donvitinhService.save(donvitinh);
		DonViTinh donvitinh2 = donvitinhService.getOneById(donvitinh.getId());
		if(donvitinh2 != null) throw new DuplicateIdException("BenhNhan", donvitinh.getId());
		
		return donvitinhService.save(donvitinh);
	}
	
	@PutMapping("/donvitinh/update/{id}")
	public DonViTinh updateDonViTinh(@PathVariable("id")Long id,
			@Valid @RequestBody DonViTinh donvitinhRequest) {
		DonViTinh donvitinh = donvitinhService.getOneById(id);
		donvitinh.setTen(donvitinhRequest.getTen());
		donvitinh.setChitiet(donvitinhRequest.getChitiet());
		
		return donvitinhService.save(donvitinh);
	}
	
	@DeleteMapping("/donvitinh/delete/{id}")
	public ResponseEntity<?> deleteDonViTinh(@PathVariable("id") Long id) {
		donvitinhService.delete(id);
		return ResponseEntity.ok().build();
	}
}



















