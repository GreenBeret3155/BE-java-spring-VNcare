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

import com.example.intern.model.Tinh;
import com.example.intern.service.ITinhService; 
  
@RestController
@RequestMapping("/api/v1")
public class TinhController {
	
	@Autowired
	private ITinhService service;
	
	@GetMapping("/tinh")
	public List<Tinh> getAllTinh(){
		return service.getAll(); 
	}
	
	@GetMapping("/tinh/{id}")
	public Tinh getTinhById( @PathVariable("id") Long id ) {
		return service.getOneById(id);
	}
	
	@PostMapping("/tinh")
	public Tinh createTinh( @Valid @RequestBody Tinh tinh) {
		return service.save(tinh);
	}
	
	@PutMapping("/tinh/{id}")
	public Tinh updateTinh(@PathVariable("id") Long id,  
			@Valid @RequestBody Tinh tinh) {
		Tinh tinhmodel = service.getOneById(id);
		
		tinhmodel.setTen(tinh.getTen());
		tinhmodel.setMota(tinh.getMota());
		
		return service.save(tinhmodel);
	}
	
	@DeleteMapping("/tinh/{id}")
	public void deleteTinh(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
}


































