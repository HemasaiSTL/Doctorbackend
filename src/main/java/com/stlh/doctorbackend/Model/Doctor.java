package com.stlh.doctorbackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//Entity Class

@Data
@Entity
@Table(name="doctorsdb")
public class Doctor {	
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long did;
	
	@Column(name="Firstname",nullable=false)
	private String firstname;

	@Column(name="Lastname")
	private String lastname;
	
	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="Phnnumber")
	private String phnnumber;
	
	@Column(name="Feild")
	private String feild;
	
	@Column(name="Qualification")
	private String qualification;
	
	@Column(name="Password")
	private String password;

	

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhnnumber() {
		return phnnumber;
	}

	public void setPhnnumber(String phnumber) {
		this.phnnumber = phnumber;
	}

	public String getFeild() {
		return feild;
	}

	public void setFeild(String feild) {
		this.feild = feild;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

	


