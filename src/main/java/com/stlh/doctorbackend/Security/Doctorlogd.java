package com.stlh.doctorbackend.Security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.stlh.doctorbackend.Model.Doctor;

@SuppressWarnings("serial")
public class Doctorlogd implements UserDetails{
	Doctor doctor = new Doctor();
	
	public Doctorlogd(Doctor doctor){
		this.doctor=doctor;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("DOCTOR"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return doctor.getPassword();
	}

	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return doctor.getEmail();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
