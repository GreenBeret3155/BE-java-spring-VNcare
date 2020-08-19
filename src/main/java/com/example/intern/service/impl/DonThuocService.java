package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.intern.model.DonThuoc;
import com.example.intern.repository.DonThuocRepository;
import com.example.intern.service.IDonThuocService;

@Service
@Transactional
public class DonThuocService implements IDonThuocService  {
	
	@Autowired
	private DonThuocRepository donthuocRepository;
	
	@Override
	public List<DonThuoc> getAll(){
		return donthuocRepository.findAll();
	}
	
	@Override
	public DonThuoc getOneById(Long id) {
		return donthuocRepository.findOne(id);
	}
	
	@Override
	public List<DonThuoc> findByDangKyKhamId(Long dangkykhamid){
		return donthuocRepository.findByDangkykhamId(dangkykhamid);
	}
	
	@Override
	public DonThuoc save(DonThuoc donthuoc) {
		return donthuocRepository.save(donthuoc);
	}
	
	@Override
	public void deleteByDangkykhamId(Long dangkykhamid) {
		donthuocRepository.deleteByDangkykhamId(dangkykhamid);
	}
}
