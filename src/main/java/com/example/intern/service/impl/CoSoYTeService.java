package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.model.CoSoYTe;
import com.example.intern.repository.CoSoYTeRepository;
import com.example.intern.service.ICoSoYTeService;

@Service
public class CoSoYTeService implements ICoSoYTeService {
	
	@Autowired
	public CoSoYTeRepository cosoyteRepository;
	
	@Override
	public List<CoSoYTe> getAll(){
		return cosoyteRepository.findAll(); 
	}
	
	@Override
	public CoSoYTe getOneById(Long id) {
		return cosoyteRepository.findOne(id);
	}
	
	@Override
	public List<CoSoYTe> findByTinhId(Long tinhid){
		return cosoyteRepository.findByTinhId(tinhid);
	}
	
	@Override
	public CoSoYTe save(CoSoYTe cosoyte) {
		return cosoyteRepository.save(cosoyte);
	}
	
	@Override
	public void delete(Long id) {
		cosoyteRepository.delete(id);
	}
}
