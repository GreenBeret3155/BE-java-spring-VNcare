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

import com.example.intern.model.CoSoYTe;
import com.example.intern.model.Khoa;
import com.example.intern.service.ICoSoYTeService;
import com.example.intern.service.IKhoaService;

@RestController
@RequestMapping("/api")
public class KhoaController {
	
	@Autowired
	private IKhoaService khoaService;
	
	@Autowired
	private ICoSoYTeService cosoyteService;
	
	@GetMapping("/khoa")
	public List<Khoa> getAll(){
		return khoaService.getAll();
	}
	
	@GetMapping("/khoa/{id}")
	public Khoa getOneById(@PathVariable("id") Long id) {
		return khoaService.getOneById(id);
	}
	
	@GetMapping("/cosoyte/{cosoyteid}/khoa")
	public List<Khoa> findByCosoyteId(@PathVariable("cosoyteid")  Long cosoyteid){
		return khoaService.findByCosoyteId(cosoyteid);
	}
	
	@PostMapping("/cosoyte/{cosoyteid}/khoa")
	public Khoa createKhoa(@PathVariable Long cosoyteid,
			@Valid @RequestBody Khoa khoaRequest) {
		CoSoYTe coSoYTe = cosoyteService.getOneById(cosoyteid);
		khoaRequest.setCosoyte(coSoYTe);
		return khoaService.save(khoaRequest);
	}
	@PutMapping("/khoa/{khoaid}")
	public Khoa updateKhoa(@PathVariable("khoaid") Long khoaid,
			@Valid @RequestBody Khoa khoaRequest){
		Khoa khoa = khoaService.getOneById(khoaid);
		khoa.setTen(khoaRequest.getTen());
		
		return khoaService.save(khoa);
	}
	
	@PutMapping("/cosoyte/{cosoyteid}/khoa/{khoaid}")
	public Khoa updateKhoaByCSYTId(@PathVariable("khoaid") Long khoaid,
			@PathVariable("cosoyteid") Long cosoyteid,
			@Valid @RequestBody Khoa khoaRequest){
		CoSoYTe cosoyte = cosoyteService.getOneById(cosoyteid);
		Khoa khoa = khoaService.getOneById(khoaid);
		khoa.setTen(khoaRequest.getTen());
		khoa.setCosoyte(cosoyte);
		
		return khoaService.save(khoa);
	}
	
	@DeleteMapping("/khoa/{id}")
	public ResponseEntity<?> deleteKhoa(@PathVariable("id") Long id) {
		khoaService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
















