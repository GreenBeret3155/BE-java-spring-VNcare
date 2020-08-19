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

import com.example.intern.model.CoSoYTe;
import com.example.intern.model.Tinh;
import com.example.intern.service.ICoSoYTeService;
import com.example.intern.service.ITinhService;

@RestController
@RequestMapping("/api/v1")
public class CoSoYTeController {
	
	@Autowired
	public ICoSoYTeService cosoyteService;
	
	@Autowired
	public ITinhService tinhService;
	
	@GetMapping("/cosoyte")
	public List<CoSoYTe> getAll(){
		return cosoyteService.getAll();
	}
	
	@GetMapping("/cosoyte/{id}")
	public CoSoYTe getOneById(@PathVariable("id") Long id  ) {
		return cosoyteService.getOneById(id);
	}
	
	@GetMapping("/cosoyte/tinh/{tinhid}")
	public List<CoSoYTe> finhByTinhId(@PathVariable("tinhid") Long tinhid){
		return cosoyteService.findByTinhId(tinhid);
	}
	
	@PostMapping("/cosoyte/tinh/{tinhid}")
	public CoSoYTe createCoSoYTe(@PathVariable("tinhid") Long tinhid,
			@Valid @RequestBody CoSoYTe cosoyte) {
		Tinh tinh = tinhService.getOneById(tinhid);
		cosoyte.setTinh(tinh);
		return cosoyteService.save(cosoyte);
	}
	
	@PutMapping("/cosoyte/{csid}/tinh//{tinhid}")
	public CoSoYTe updateCoSoYTe(@PathVariable("csid") Long csid,
			@PathVariable("tinhid") Long tinhid,
			@Valid @RequestBody CoSoYTe cosoyte ) {
		Tinh tinh = tinhService.getOneById(tinhid);
		CoSoYTe cs = cosoyteService.getOneById(csid);
		cs.setTen(cosoyte.getTen());
		cs.setTinh(tinh);
		
		return cosoyteService.save(cs);
	}
	
	@DeleteMapping("/cosoyte/{id}")
	public void delete(@PathVariable("id") Long id) {
		cosoyteService.delete(id);
	}
	
}
