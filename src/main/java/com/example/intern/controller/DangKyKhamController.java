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

import com.example.intern.model.BacSi;
import com.example.intern.model.Benh;
import com.example.intern.model.BenhNhan;
import com.example.intern.model.DangKyKham;
import com.example.intern.service.IBacSiService;
import com.example.intern.service.IBenhNhanService;
import com.example.intern.service.IBenhService;
import com.example.intern.service.IDangKyKhamService;

@RestController
@RequestMapping("/api")
public class DangKyKhamController {
	
	@Autowired
	private IDangKyKhamService dangkykhamService;
	
	@Autowired
	private IBacSiService bacsiService;
	
	@Autowired
	private IBenhNhanService benhnhanService;
	
	@Autowired
	private IBenhService benhService;
	
	@GetMapping("/dangkykham")
	public List<DangKyKham> getAll(){
		return dangkykhamService.getAll();
	}
	
	@GetMapping("/dangkykham/{id}")
	public DangKyKham getOneById(@PathVariable("id")Long id) {
		return dangkykhamService.getOneById(id);
	}
	
	@GetMapping("/benhchinh/{benhchinhid}/dangkykham")
	public List<DangKyKham> findByBenhchinhId(@PathVariable("benhchinhid")Long benhchinhid) {
		return dangkykhamService.findByBenhId(benhchinhid);
	}
	
	@GetMapping("/bacsi/{bacsiid}/dangkykham")
	public List<DangKyKham> findByBacsiId(@PathVariable("bacsiid")Long bacsiid){
		return dangkykhamService.findByBacsiId(bacsiid);
	}
	
	@GetMapping("/benhnhan/{benhnhanid}/dangkykham")
	public List<DangKyKham> findByBenhnhanId(@PathVariable("benhnhanid")Long benhnhanid){
		return dangkykhamService.findByBenhnhanId(benhnhanid);
	}
	
	@PostMapping("/benhnhan/{benhnhanid}/bacsi/{bacsiid}/benhchinh/{benhchinhid}/dangkykham")
	public DangKyKham createDangKyKham(@PathVariable("benhnhanid")Long benhnhanid,
			@PathVariable("bacsiid")Long bacsiid,
			@PathVariable("benhchinhid")Long benhchinhid,
			@Valid @RequestBody DangKyKham dangkykhamRequest) {
		Benh benh = benhService.getOneById(benhchinhid);
		BenhNhan benhnhan = benhnhanService.getOneById(benhnhanid);
		BacSi bacsi = bacsiService.getOneById(bacsiid);
		
		dangkykhamRequest.setBacsi(bacsi);
		dangkykhamRequest.setBenh(benh);
		dangkykhamRequest.setBenhnhan(benhnhan);
		
		return dangkykhamService.save(dangkykhamRequest);
	}
	
	@PostMapping("/benhnhan/{benhnhanid}/bacsi/{bacsiid}/dangkykham")
	public DangKyKham createDangKyKhamWhithoutBenhchinhId(@PathVariable("benhnhanid")Long benhnhanid,
			@PathVariable("bacsiid")Long bacsiid,
			@Valid @RequestBody DangKyKham dangkykhamRequest) {
		BenhNhan benhnhan = benhnhanService.getOneById(benhnhanid);
		BacSi bacsi = bacsiService.getOneById(bacsiid);
		
		dangkykhamRequest.setBacsi(bacsi);
		dangkykhamRequest.setBenhnhan(benhnhan);
		
		return dangkykhamService.save(dangkykhamRequest);
	}
	
	@PutMapping("/benhnhan/{benhnhanid}/bacsi/{bacsiid}/benhchinh/{benhchinhid}/dangkykham/{id}")
	public DangKyKham createDangKyKham(@PathVariable("id")Long id,
			@PathVariable("benhnhanid")Long benhnhanid,
			@PathVariable("benhchinhid")Long benhchinhid,
			@PathVariable("bacsiid")Long bacsiid,
			@Valid @RequestBody DangKyKham dangkykhamRequest) {
		Benh benh = benhService.getOneById(benhchinhid);
		BenhNhan benhnhan = benhnhanService.getOneById(benhnhanid);
		BacSi bacsi = bacsiService.getOneById(bacsiid);
		DangKyKham dangkykham = dangkykhamService.getOneById(id);
		
		dangkykham.setThoigiandk(dangkykhamRequest.getThoigiandk());
		dangkykham.setThoigiankham(dangkykhamRequest.getThoigiankham());
		dangkykham.setTrangthaikham(dangkykhamRequest.isTrangthaikham());
		dangkykham.setNoidungkham(dangkykhamRequest.getNoidungkham());
		dangkykham.setLoaikham(dangkykhamRequest.getLoaikham());
		dangkykham.setBenhphu(dangkykhamRequest.getBenhphu());
		dangkykham.setMota(dangkykhamRequest.getMota());
		dangkykham.setBenh(benh);
		dangkykham.setBacsi(bacsi);
		dangkykham.setBenhnhan(benhnhan);
		
		return dangkykhamService.save(dangkykham);
	}
	
	@PutMapping("/benhnhan/{benhnhanid}/bacsi/{bacsiid}/dangkykham/{id}")
	public DangKyKham createDangKyKhamWithoutBenhchinhId(@PathVariable("id")Long id,
			@PathVariable("benhnhanid")Long benhnhanid,
			@PathVariable("bacsiid")Long bacsiid,
			@Valid @RequestBody DangKyKham dangkykhamRequest) {
		BenhNhan benhnhan = benhnhanService.getOneById(benhnhanid);
		BacSi bacsi = bacsiService.getOneById(bacsiid);
		DangKyKham dangkykham = dangkykhamService.getOneById(id);
		
		dangkykham.setThoigiandk(dangkykhamRequest.getThoigiandk());
		dangkykham.setThoigiankham(dangkykhamRequest.getThoigiankham());
		dangkykham.setTrangthaikham(dangkykhamRequest.isTrangthaikham());
		dangkykham.setNoidungkham(dangkykhamRequest.getNoidungkham());
		dangkykham.setLoaikham(dangkykhamRequest.getLoaikham());
		dangkykham.setBenhphu(dangkykhamRequest.getBenhphu());
		dangkykham.setMota(dangkykhamRequest.getMota());
		dangkykham.setBacsi(bacsi);
		dangkykham.setBenhnhan(benhnhan);
		
		return dangkykhamService.save(dangkykham);
	}
	
	@DeleteMapping("/dangkykham/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")Long id) {
		dangkykhamService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}	





























