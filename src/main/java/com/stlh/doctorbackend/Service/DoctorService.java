package com.stlh.doctorbackend.Service;

import java.util.List;

import com.stlh.doctorbackend.Model.Doctor;

public interface DoctorService {
	
	Doctor saveDoctor(Doctor doctor);
	List<Doctor> getAllDoctors();
	Doctor getDoctorById(String email);
	Doctor updateDoctor(Doctor doctor,String email);
	void deleteDoctor(String email);


}
