package com.stlh.doctorbackend.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stlh.doctorbackend.Model.Doctor;
import com.stlh.doctorbackend.Service.DoctorService;
import com.stlh.doctorbackend.jwt.JwtUtils;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin("http://localhost:3000")
public class DoctorController {
	private DoctorService doctorService;
	@Autowired
	AuthenticationManager authmanage;
	
	@Autowired
	JwtUtils jwtUtils;
	
	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	
	
	//build create employee REST API
	@PostMapping("/add")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
		String pass =doctor.getPassword();
		doctor.setPassword(new BCryptPasswordEncoder().encode(pass));
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
	}
	

	//Build get all Doctors REST API
	@GetMapping("/alldoctors")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();	
	}
	
	@GetMapping("/get/{email}")
	//http://localhost:8091/api/doctors/1 for @pathvariable
	public ResponseEntity<Doctor> getDoctorId(@PathVariable("email") String email){
		return new ResponseEntity<Doctor>(doctorService.getDoctorById(email),HttpStatus.OK);
	}
		
	//Build Update employee REST API
	//http://localhost:8091/api/doctors/1/ for @pathvariable
	@PutMapping("/update/{email}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable("email") String email
			                                    ,@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorService.updateDoctor(doctor,email),HttpStatus.OK);
	}
	
	
	//Build delete employee REST API
	//http://localhost:8091/api/doctors/1/ for @pathvariable
	@DeleteMapping("/delete/{email}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("email") String email){
		
		doctorService.deleteDoctor(email);
		return new ResponseEntity<String>("Doctor Deleted Successfull!.",HttpStatus.OK);
	}
	
	//login
	@PostMapping("/authenticate")
	public String authDoctor(@RequestBody Doctor doctor){
		try {
			@SuppressWarnings("unused")
			Authentication authtoken=  authmanage.authenticate(
					new UsernamePasswordAuthenticationToken(doctor.getEmail(), doctor.getPassword()));
			String token = jwtUtils.generateToken(doctor.getEmail().toString());
			return token;
			
		} catch (Exception e) {
			// TODO: handle exception
			return "Login Failed";
		}
		
		
	}
	
}













