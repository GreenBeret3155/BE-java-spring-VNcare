package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.model.BacSi;
import com.example.intern.repository.BacSiRepository;
import com.example.intern.service.IBacSiService;
import com.example.intern.exception.*;

@Service
public class BacSiService implements IBacSiService {

	@Autowired
	private BacSiRepository bacsiRepository;
	
	@Override
	public List<BacSi> getAll() throws ResourceNotFoundException{
		List<BacSi> bacsi = bacsiRepository.findAll();
		if(bacsi == null ) throw new ResourceNotFoundException("BacSi");
		return bacsi;
	}
	
	@Override
	public BacSi getOneById(Long id) throws ResourceNotFoundException{
		BacSi bacsi = bacsiRepository.findOne(id);
		if(bacsi == null) throw new ResourceNotFoundException("BacSi","id",id);
		return bacsi;
	}
	
	@Override
	public List<BacSi> findByKhoaId(Long khoaid) throws ResourceNotFoundException{
		List<BacSi> bacsi = bacsiRepository.findByKhoaId(khoaid);
		if(bacsi == null) throw new ResourceNotFoundException("BacSi");
		return bacsi;
	}
	
	@Override
	public BacSi findByTaikhoanId(Long taikhoanid) throws ResourceNotFoundException{
		BacSi bacsi = bacsiRepository.findByTaikhoanId(taikhoanid);
		if(bacsi == null) throw new ResourceNotFoundException("BacSi","taikhoanid",taikhoanid);
		return bacsi;
	}
	
	@Override
	public BacSi save(BacSi bacsi) {
		return bacsiRepository.save(bacsi);
	}
	
	@Override
	public void delete(Long id) {
		bacsiRepository.delete(id);
	}
}
