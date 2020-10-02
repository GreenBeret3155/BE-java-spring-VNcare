package com.example.intern.service.impl;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.TaiKhoan;
import com.example.intern.repository.TaiKhoanRepository;
import com.example.intern.service.ITaiKhoanService;

@Service(value = "userService")
public class TaiKhoanService implements UserDetailsService, ITaiKhoanService {
	
	@Autowired
	private TaiKhoanRepository taikhoanRepository;
	
//	@Override
//	public List<TaiKhoan> queryByUsernameAndSdt(String email, String sdt) throws ResourceNotFoundException{
//		if(email == null && sdt == null) return taikhoanRepository.findAll();
//		if(email == null ) {
//			List<TaiKhoan> taikhoan = taikhoanRepository.findBySdtContaining(sdt);
//			if( taikhoan.size() ==0 ) throw new ResourceNotFoundException("TaiKhoan","sdt",sdt);
//			return taikhoan;
//		}
//		if(sdt == null) {
//			List<TaiKhoan> taikhoan = taikhoanRepository.findByUsernameContaining(email);
//			if( taikhoan.size() ==0 ) throw new ResourceNotFoundException("TaiKhoan", "email",email);
//			return taikhoan;
//		}
//		List<TaiKhoan> taikhoan = taikhoanRepository.findByUsernameContainingAndSdtContaining(email,sdt);
//		if( taikhoan.size() ==0 ) throw new ResourceNotFoundException("TaiKhoan");
//		return taikhoan;
//	}
	
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        TaiKhoan user = taikhoanRepository.findByUsername(userId);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), getAuthority());
    }
	
	private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
	
	@Override
	public TaiKhoan getOneById(Long id) throws ResourceNotFoundException{
		TaiKhoan taikhoan = taikhoanRepository.findOne(id);
		if(taikhoan == null) throw new ResourceNotFoundException("TaiKhoan", "id", id);
		return taikhoan;
	}
	
	@Override
	public TaiKhoan save(TaiKhoan taikhoan) {
		return taikhoanRepository.save(taikhoan);
	}
	
	@Override
	public void delete(Long id) {
		taikhoanRepository.delete(id);
	}

}
