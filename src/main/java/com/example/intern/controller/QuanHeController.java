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

import com.example.intern.service.IBenhNhanService;
import com.example.intern.service.IQuanHeService;
import com.example.intern.model.BenhNhan;
import com.example.intern.model.QuanHe;

@RestController
@RequestMapping("/api")
public class QuanHeController {
	
	@Autowired
	private IQuanHeService quanheService;
	
	@Autowired
	private IBenhNhanService benhnhanService;
	
	@GetMapping("/quanhe")
	public List<QuanHe> getAll(){
		return quanheService.getAll();
	}
	
	@GetMapping("/quanhe/benhnhan/{benhnhanchinhid}")
	public List<QuanHe> findByBenhnhanchinhId(@PathVariable("benhnhanchinhid")Long benhnhanchinhid){
		return quanheService.findByBenhnhanchinhId(benhnhanchinhid);
	}
	
	@PostMapping("/quanhe/benhnhan/{benhnhanchinhid}/{benhnhanphuid}")
	public QuanHe createQuanHe(@PathVariable("benhnhanchinhid")Long benhnhanchinhid,
			@PathVariable("benhnhanphuid")Long benhnhanphuid,
			@Valid @RequestBody QuanHe quanheRequest) {
		BenhNhan benhnhanchinh = benhnhanService.getOneById(benhnhanchinhid);
		BenhNhan benhnhanphu = benhnhanService.getOneById(benhnhanphuid);
		quanheRequest.setBenhnhanchinh(benhnhanchinh);
		quanheRequest.setBenhnhanphu(benhnhanphu);
		
		return quanheService.save(quanheRequest);
	}
	
	@PutMapping("/quanhe/benhnhan/{benhnhanchinhid}/{benhnhanphuid}")
	public QuanHe updateQuanHe(@PathVariable("benhnhanchinhid")Long benhnhanchinhid,
			@PathVariable("benhnhanphuid")Long benhnhanphuid,
			@Valid @RequestBody QuanHe quanheRequest) {
		BenhNhan benhnhanchinh = benhnhanService.getOneById(benhnhanchinhid);
		BenhNhan benhnhanphu = benhnhanService.getOneById(benhnhanphuid);
		QuanHe quanhe = quanheService.findByBenhnhanchinhIdAndBenhnhanphuId(benhnhanchinhid, benhnhanphuid);
		quanhe.setLoaiquanhe(quanheRequest.getLoaiquanhe());
		quanhe.setBenhnhanchinh(benhnhanchinh);
		quanhe.setBenhnhanphu(benhnhanphu);
		
		return quanheService.save(quanhe);
	}
	
	@DeleteMapping("/quanhe/benhnhan/{benhnhanchinhid}/{benhnhanphuid}")
	public ResponseEntity<?> deleteQuanHe(@PathVariable("benhnhanchinhid")Long benhnhanchinhid,
			@PathVariable("benhnhanphuid")Long benhnhanphuid) {
		BenhNhan benhnhanchinh = benhnhanService.getOneById(benhnhanchinhid);
		BenhNhan benhnhanphu = benhnhanService.getOneById(benhnhanphuid);
		quanheService.deleleByBenhnhanchinhIdAndBenhnhanphu(benhnhanchinh, benhnhanphu);
		return ResponseEntity.ok().build();
	}
}















