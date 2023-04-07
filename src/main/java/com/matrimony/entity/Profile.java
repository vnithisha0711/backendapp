package com.matrimony.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Profile {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	
	private String fullName;
		
	private int age;
	
	private String gender;
	
	private double height;
	
	private int contactNumber;
	
	private String caste;
	
	private String religion;
	
	private String star;
	
	private String motherTongue;
	
	private String Residence;
	
	private double income;
	
	private String citizenship;
	
	private String education;
	
	private String description;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name="profile_images",
	joinColumns= {
			@JoinColumn(name="profile_id")
//			@JoinColumn
	},
	inverseJoinColumns = {
			@JoinColumn(name="image_id")
	})
	private Set<ImageModel> profileImages;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMotherTongue() {
		return motherTongue;
	}

	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}

	public String getResidence() {
		return Residence;
	}

	public void setResidence(String residence) {
		Residence = residence;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ImageModel> getProfileImages() {
		return profileImages;
	}
	
	public void setProfileImages(Set<ImageModel> profileImages) {
		this.profileImages = profileImages;
	}
	
	
	
}