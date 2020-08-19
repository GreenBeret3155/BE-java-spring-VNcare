package com.example.intern.service;

import java.util.List;
import com.example.intern.model.Tinh;

public interface ITinhService {
	List<Tinh> getAll();
	Tinh getOneById(Long id);
	Tinh save(Tinh tinh);
	void delete(Long id);
}
