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
	public List<DangKyKham> getAll() throws ResourceNotFoundException{
		List<DangKyKham> dangkykham = dangkykhamRepository.findAll();
		if(dangkykham == null ) throw new ResourceNotFoundException("DangKyKham");
		return dangkykham;
	}
	
	@Override
	public DangKyKham getOneById(Long id) throws ResourceNotFoundException{
		DangKyKham dangkykham = dangkykhamRepository.findOne(id);
		if(dangkykham == null ) throw new ResourceNotFoundException("DangKyKham","id",id);
		return dangkykham;
	}
	
	@Override
	public List<DangKyKham> findByBenhnhanId(Long benhnhanid) throws ResourceNotFoundException{
		List<DangKyKham> dangkykham = dangkykhamRepository.findByBenhnhanId(benhnhanid);
		if(dangkykham == null ) throw new ResourceNotFoundException("DangKyKham","benhnhanid",benhnhanid);
		return dangkykham;
	}
	
	@Override
	public List<DangKyKham> findByBacsiId(Long bacsiid) throws ResourceNotFoundException{
		List<DangKyKham> dangkykham = dangkykhamRepository.findByBacsiId(bacsiid);
		if(dangkykham == null ) throw new ResourceNotFoundException("DangKyKham","bacsiid",bacsiid);
		return dangkykham;
	}
	
	@Override
	public List<DangKyKham> findByBenhId(Long benhchinhid) throws ResourceNotFoundException{
		List<DangKyKham> dangkykham = dangkykhamRepository.findByBenhId(benhchinhid);
		if(dangkykham == null ) throw new ResourceNotFoundException("DangKyKham","benhchinhid",benhchinhid);
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
















