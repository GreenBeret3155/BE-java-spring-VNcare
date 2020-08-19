package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.model.Khoa;
import com.example.intern.repository.KhoaRepository;
import com.example.intern.service.IKhoaService;

@Service
public class KhoaService implements IKhoaService {
	
	@Autowired
	private KhoaRepository khoaRepository;
	
	@Override
	public List<Khoa> getAll(){
		return khoaRepository.findAll();
	}
	
	@Override
	public Khoa getOneById(Long id) {
		return khoaRepository.findOne(id);
	}
	
	@Override
	public List<Khoa> findByCosoyteId(Long cosoyteid){
		return khoaRepository.findByCosoyteId(cosoyteid);
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
