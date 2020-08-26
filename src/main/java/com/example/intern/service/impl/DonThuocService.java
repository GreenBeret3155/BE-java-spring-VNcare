package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.intern.exception.DuplicateIdException;
import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.DonThuoc;
import com.example.intern.repository.DonThuocRepository;
import com.example.intern.service.IDonThuocService;

@Service
@Transactional
public class DonThuocService implements IDonThuocService  {
	
	@Autowired
	private DonThuocRepository donthuocRepository;
	
	@Override
	public List<DonThuoc> getAll() throws ResourceNotFoundException{
		List<DonThuoc> donthuoc = donthuocRepository.findAll();
		if(donthuoc == null ) throw new ResourceNotFoundException("DonThuoc");
		return donthuoc;
	}
	
	@Override
	public DonThuoc getOneById(Long id) throws ResourceNotFoundException{
		DonThuoc donthuoc = donthuocRepository.findOne(id);
		if(donthuoc == null ) throw new ResourceNotFoundException("DonThuoc");
		return donthuoc;
	}
	
	@Override
	public List<DonThuoc> findByDangKyKhamId(Long dangkykhamid) throws ResourceNotFoundException{
		List<DonThuoc> donthuoc = donthuocRepository.findByDangkykhamId(dangkykhamid);
		if(donthuoc == null ) throw new ResourceNotFoundException("DonThuoc");
		return donthuoc;
	}
	
	@Override
	public DonThuoc save(DonThuoc donthuoc) {
		if(donthuoc.getId() == null) return donthuocRepository.save(donthuoc);
		DonThuoc donthuoc2 = donthuocRepository.getOne(donthuoc.getId());
		if(donthuoc2 != null) throw new DuplicateIdException("DonThuoc", donthuoc.getId());
		return donthuocRepository.save(donthuoc);
	}
	
	@Override 
	public void delete(Long id) {
		donthuocRepository.delete(id);
	}
	
	@Override
	public void deleteByDangkykhamId(Long dangkykhamid) {
		donthuocRepository.deleteByDangkykhamId(dangkykhamid);
	}
}
