package com.stlh.doctorbackend.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stlh.doctorbackend.Model.Doctor;
import com.stlh.doctorbackend.Repository.DoctorRepository;

@Service
public class DoctorlogdService implements UserDetailsService{
	@Autowired
	DoctorRepository doctorRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Doctor doctor = doctorRepository.findById(username).get();
		if(doctor == null) {
			return null;
		}
		
		return new Doctorlogd(doctor);
	}
	
}
