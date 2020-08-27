package com.example.intern.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.intern.exception.DuplicateIdException;
import com.example.intern.model.Thuoc;
import com.example.intern.service.IThuocService;

@RestController
@RequestMapping("/api")
public class ThuocController {
	
	@Autowired
	private IThuocService thuocService;

	@GetMapping("/thuoc/search")
	public List<Thuoc> queryThuoc(@RequestParam(name = "ten", required = false )String ten){
		return thuocService.queryByTen(ten);
	}

	@GetMapping("/thuoc/details/{id}")
	public Thuoc getOneById(@PathVariable("id") Long id) {
		return thuocService.getOneById(id);
	}
	
	@PostMapping("/thuoc/create")
	public Thuoc createThuoc (@Valid @RequestBody Thuoc thuoc) {
		if(thuoc.getId() == null) return thuocService.save(thuoc);
		Thuoc thuoc2 = thuocService.getOneById(thuoc.getId());
		if(thuoc2 != null) throw new DuplicateIdException("Thuoc", thuoc.getId());
		
		return thuocService.save(thuoc);
	}
	
	@PutMapping("/thuoc/update/{id}")
	public Thuoc updateThuoc ( @PathVariable("id") Long id,	
			@Valid @RequestBody Thuoc thuocRequest) {
		Thuoc thuoc = thuocService.getOneById(id);
		thuoc.setTen(thuocRequest.getTen());
		thuoc.setMota(thuocRequest.getMota());
		
		return thuocService.save(thuoc);
	}
	
	@DeleteMapping("/thuoc/delete/{id}")
	public ResponseEntity<?> deleteThuoc(@PathVariable("id")Long id) {
		thuocService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
