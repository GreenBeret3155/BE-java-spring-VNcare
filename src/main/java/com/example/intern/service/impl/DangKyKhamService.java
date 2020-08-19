package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.model.DangKyKham;
import com.example.intern.repository.DangKyKhamRepository;
import com.example.intern.service.IDangKyKhamService;

@Service
public class DangKyKhamService implements IDangKyKhamService {
	
	@Autowired
	private DangKyKhamRepository dangkykhamRepository;
	
	@Override
	public List<DangKyKham> getAll(){
		return dangkykhamRepository.findAll();
	}
	
	@Override
	public DangKyKham getOneById(Long id) {
		return dangkykhamRepository.findOne(id);
	}
	
	@Override
	public List<DangKyKham> findByBenhnhanId(Long benhnhanid){
		return dangkykhamRepository.findByBenhnhanId(benhnhanid);
	}
	
	@Override
	public List<DangKyKham> findByBacsiId(Long bacsiid){
		return dangkykhamRepository.findByBacsiId(bacsiid);
	}
	
	@Override
	public List<DangKyKham> findByBenhId(Long benhchinhid){
		return dangkykhamRepository.findByBenhId(benhchinhid);
	}
	
	@Override
	public DangKyKham save(DangKyKham dangkykham) {
		return dangkykhamRepository.save(dangkykham);
	}
	
	@Override
	public void delete(Long id) {
		dangkykhamRepository.delete(id);
	}
}
















