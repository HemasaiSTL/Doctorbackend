package com.stlh.doctorbackend.Service.Impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.stlh.doctorbackend.Exception.ResourceNotFoundException;
import com.stlh.doctorbackend.Model.Doctor;
import com.stlh.doctorbackend.Repository.DoctorRepository;
import com.stlh.doctorbackend.Service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	//inject EmployeeRepository dependency Doa
	private DoctorRepository doctorRepository;
	

	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}


	@Override
	public Doctor saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}


	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}


	@Override
	public Doctor getDoctorById(String email) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee","Id",id);
//		}
		//lambda representation
		//optional has orelsethrow
		return doctorRepository.findById(email).orElseThrow(() -> new ResourceNotFoundException("Doctor","Id",email));
		
	}


	@Override
	public Doctor updateDoctor(Doctor doctor, String email) {
		// we need to check whether employee with given id is exist in DB or not
		Doctor existingDoctor = doctorRepository.findById(email).orElseThrow(() -> new ResourceNotFoundException("Doctor","Id",email));
		existingDoctor.setFirstname((doctor).getFirstname());
		existingDoctor.setLastname(doctor.getLastname());
		existingDoctor.setEmail(doctor.getEmail());
		existingDoctor.setFeild(doctor.getFeild());
		existingDoctor.setQualification(doctor.getQualification());
		existingDoctor.setPhnnumber(doctor.getPhnnumber());
		//save existing employee to DB
		doctorRepository.save(existingDoctor);
		return existingDoctor;
	}


	@Override
	public void deleteDoctor(String email) {
		//check whether a employee exists in DB or not
		doctorRepository.findById(email).orElseThrow(() -> new ResourceNotFoundException("Doctor","Id",email));
		doctorRepository.deleteById(email);
		
	}

}
