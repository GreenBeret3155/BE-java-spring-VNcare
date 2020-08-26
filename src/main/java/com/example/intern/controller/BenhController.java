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
import com.example.intern.model.Benh;
import com.example.intern.service.IBenhService;

@RestController
@RequestMapping("/api")
public class BenhController {
	
	@Autowired
	private IBenhService benhService;
	
	@GetMapping("/benh")
	public List<Benh> getAll(){
		return benhService.getAll();
	}
	
	@GetMapping("/benh/details/{id}")
	public Benh getOneById(@PathVariable("id") Long id) {
		return benhService.getOneById(id);
	}
	
	@PostMapping("/benh/create")
	public Benh createBenh(@Valid @RequestBody Benh benh) {
		if(benh.getId() == null) return benhService.save(benh);
		Benh benh2 = benhService.getOneById(benh.getId());
		if(benh2 != null) throw new DuplicateIdException("Benh", benh.getId());
		
		return benhService.save(benh);
	}
	
	@PutMapping("/benh/update/{id}")
	public Benh updateBenh (@PathVariable("id")Long id,
			@Valid @RequestBody Benh benhRequest) {
		Benh benh = benhService.getOneById(id);
		benh.setTen(benhRequest.getTen());
		benh.setMabenh(benhRequest.getMabenh());
		benh.setMota(benhRequest.getMota());
		
		return benhService.save(benh);
	}
	
	@DeleteMapping("/benh/delete/{id}")
	public ResponseEntity<?> deleteBenh(@PathVariable("id")Long id) {
		benhService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}


