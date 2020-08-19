package com.example.intern.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intern.model.DonViTinh;
import com.example.intern.service.IDonViTinhService;

@RestController
@RequestMapping("/api/v1")
public class DonViTinhController {
	
	@Autowired
	private IDonViTinhService donvitinhService;
	
	@GetMapping("/donvitinh")
	public List<DonViTinh> getAll(){
		return donvitinhService.getAll();
	}
	
	@GetMapping("/donvitinh/{id}")
	public DonViTinh getOneById(@PathVariable("id") Long id) {
		return donvitinhService.getOneById(id);
	}
	
	@PostMapping("/donvitinh")
	public DonViTinh createDonViTinh(@Valid @RequestBody DonViTinh donvitinhRequest) {
		return donvitinhService.save(donvitinhRequest);
	}
	
	@PutMapping("/donvitinh/{id}")
	public DonViTinh updateDonViTinh(@PathVariable("id")Long id,
			@Valid @RequestBody DonViTinh donvitinhRequest) {
		DonViTinh donvitinh = donvitinhService.getOneById(id);
		donvitinh.setTen(donvitinhRequest.getTen());
		donvitinh.setChitiet(donvitinhRequest.getChitiet());
		
		return donvitinhService.save(donvitinh);
	}
	
	@DeleteMapping("/donvitinh/{id}")
	public void deleteDonViTinh(@PathVariable("id") Long id) {
		donvitinhService.delete(id);
	}
}



















