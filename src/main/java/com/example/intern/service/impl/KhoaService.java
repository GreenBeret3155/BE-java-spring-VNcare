package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.Khoa;
import com.example.intern.repository.KhoaRepository;
import com.example.intern.service.IKhoaService;

@Service
public class KhoaService implements IKhoaService {
	
	@Autowired
	private KhoaRepository khoaRepository;
	
	@Override
	public List<Khoa> getAll() throws ResourceNotFoundException{
		List<Khoa> khoa = khoaRepository.findAll();
		if(khoa == null) throw new ResourceNotFoundException("Khoa");
		return khoa;
	}
	
	@Override
	public Khoa getOneById(Long id) throws ResourceNotFoundException{
		Khoa khoa = khoaRepository.findOne(id);
		if(khoa == null) throw new ResourceNotFoundException("Khoa","id",id);
		return khoa;
	}
	
	@Override
	public List<Khoa> findByCosoyteId(Long cosoyteid) throws ResourceNotFoundException{
		List<Khoa> khoa = khoaRepository.findByCosoyteId(cosoyteid);
		if(khoa == null) throw new ResourceNotFoundException("Khoa","cosoyteid",cosoyteid);
		return khoa;
	}
	
	@Override
	public Khoa save(Khoa khoa) {
		return khoaRepository.save(khoa);
	}
	
	@Override
	public void delete(Long id) {
		khoaRepository.delete(id);
	}
	
}
