package com.stlh.doctorbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stlh.doctorbackend.Model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,String>{
	

}