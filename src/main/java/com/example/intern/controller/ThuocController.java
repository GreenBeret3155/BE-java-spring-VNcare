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

import com.example.intern.model.Thuoc;
import com.example.intern.service.IThuocService;

@RestController
@RequestMapping("/api/v1")
public class ThuocController {
	
	@Autowired
	private IThuocService thuocService;
	
	@GetMapping("/thuoc")
	public List<Thuoc> getAll(){
		return thuocService.getAll();
	}
	
	@GetMapping("/thuoc/{id}")
	public Thuoc getOneById(@PathVariable("id") Long id) {
		return thuocService.getOneById(id);
	}
	
	@PostMapping("/thuoc")
	public Thuoc createThuoc (@Valid @RequestBody Thuoc thuocRequest) {
		return thuocService.save(thuocRequest);
	}
	
	@PutMapping("/thuoc/{id}")
	public Thuoc updateThuoc ( @PathVariable("id") Long id,
			@Valid @RequestBody Thuoc thuocRequest) {
		Thuoc thuoc = thuocService.getOneById(id);
		thuoc.setTen(thuocRequest.getTen());
		thuoc.setMota(thuocRequest.getMota());
		
		return thuocService.save(thuoc);
	}
	
	@DeleteMapping("/thuoc")
	public void deleteThuoc(Long id) {
		thuocService.delete(id);
	}
	
}
