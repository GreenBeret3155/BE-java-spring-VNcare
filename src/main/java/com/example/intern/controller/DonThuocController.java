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

import com.example.intern.model.DangKyKham;
import com.example.intern.model.DonThuoc;
import com.example.intern.model.DonViTinh;
import com.example.intern.model.Thuoc;
import com.example.intern.service.IDangKyKhamService;
import com.example.intern.service.IDonThuocService;
import com.example.intern.service.IDonViTinhService;
import com.example.intern.service.IThuocService;

@RestController
@RequestMapping("/api")
public class DonThuocController {
	
	@Autowired
	private IDonThuocService donthuocService;
	
	@Autowired
	private IDangKyKhamService dangkykhamService;
	
	@Autowired
	private IThuocService thuocService;
	
	@Autowired
	private IDonViTinhService donvitinhService;
	
	@GetMapping("/donthuoc")
	public List<DonThuoc> getAll(){
		return donthuocService.getAll();
	}
	
	@GetMapping("/donthuoc/{id}")
	public DonThuoc getOneById(@PathVariable("id")Long id) {
		return donthuocService.getOneById(id);
	}
	
	@GetMapping("/donthuoc/dangkykham/{dangkykhamid}")
	public List<DonThuoc> findByDangkykhamId(@PathVariable("dangkykhamid")Long dangkykhamid){
		return donthuocService.findByDangKyKhamId(dangkykhamid);
	}
	
	@PostMapping("/donthuoc/dangkykham/{dangkykhamid}/thuoc/{thuocid}/donvitinh/{donvitinhid}")
	public DonThuoc createDonThuoc (@PathVariable("dangkykhamid")Long dangkykhamid,
			@PathVariable("thuocid")Long thuocid,
			@PathVariable("donvitinhid")Long donvitinhid,
			@Valid @RequestBody DonThuoc donthuocRequest) {
		DangKyKham dangkykham = dangkykhamService.getOneById(dangkykhamid);
		Thuoc thuoc = thuocService.getOneById(thuocid);
		DonViTinh donvitinh = donvitinhService.getOneById(donvitinhid);
		donthuocRequest.setDangkykham(dangkykham);
		donthuocRequest.setDonvitinh(donvitinh);
		donthuocRequest.setThuoc(thuoc);
		
		return donthuocService.save(donthuocRequest);
	}
	
	@PutMapping("/donthuoc/{id}/dangkykham/{dangkykhamid}/thuoc/{thuocid}/donvitinh/{donvitinhid}")
	public DonThuoc updateDonThuoc (@PathVariable("id")Long id,
			@PathVariable("dangkykhamid")Long dangkykhamid,
			@PathVariable("thuocid")Long thuocid,
			@PathVariable("donvitinhid")Long donvitinhid,
			@Valid @RequestBody DonThuoc donthuocRequest) {
		DangKyKham dangkykham = dangkykhamService.getOneById(dangkykhamid);
		Thuoc thuoc = thuocService.getOneById(thuocid);
		DonViTinh donvitinh = donvitinhService.getOneById(donvitinhid);
		DonThuoc donthuoc = donthuocService.getOneById(id);
		donthuoc.setSoluong(donthuocRequest.getSoluong());
		donthuoc.setHuongdan(donthuocRequest.getHuongdan());
		donthuoc.setDangkykham(dangkykham);
		donthuoc.setDonvitinh(donvitinh);
		donthuoc.setThuoc(thuoc);
		
		return donthuocService.save(donthuocRequest);
	}
	
	@DeleteMapping("/donthuoc/{id}")
	public ResponseEntity<?> deleteDonThuoc(@PathVariable("id")Long id) {
		donthuocService.deleteByDangkykhamId(id);
		return ResponseEntity.ok().build();
	}
	
	
	@DeleteMapping("/donthuoc/dangkykham/{dangkykhamid}")
	public ResponseEntity<?> deleteDonThuocByDangkykhamId(@PathVariable("dangkykhamid")Long dangkykhamid) {
		donthuocService.deleteByDangkykhamId(dangkykhamid);
		return ResponseEntity.ok().build();
	}
	
}
