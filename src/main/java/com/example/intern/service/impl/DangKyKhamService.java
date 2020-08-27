package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.DangKyKham;
import com.example.intern.repository.DangKyKhamRepository;
import com.example.intern.service.IDangKyKhamService;

@Service
public class DangKyKhamService implements IDangKyKhamService {
	
	@Autowired
	private DangKyKhamRepository dangkykhamRepository;

	@Override
	public List<DangKyKham> queryQuery(Long benhnhanId, Long bacsiId, Long benhchinhId) {
		if(benhnhanId == null && bacsiId == null &&benhchinhId == null) return dangkykhamRepository.findAll();
		if(bacsiId == null && benhchinhId == null){
			List<DangKyKham> dangKyKham = dangkykhamRepository.findByBenhnhanId(benhnhanId);
			if(dangKyKham.size() == 0) throw new ResourceNotFoundException("DangKyKham","benhnhanid",benhnhanId);
			return dangKyKham;
		}
		return dangkykhamRepository.findAll();		//cai nay dang sai va thieu, viet de push len thoi
	}

	@Override
	public DangKyKham getOneById(Long id) throws ResourceNotFoundException{
		DangKyKham dangkykham = dangkykhamRepository.findOne(id);
		if(dangkykham == null ) throw new ResourceNotFoundException("DangKyKham","id",id);
		return dangkykham;
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
















