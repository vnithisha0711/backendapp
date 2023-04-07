package com.matrimony.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.dao.ProfileDao;
import com.matrimony.entity.Profile;

@Service
public class ProfileService {

	@Autowired
	private ProfileDao profileDao;

	public Profile addNewProfile(Profile profile) {
     return profileDao.save(profile);
     
	}
	
	public List<Profile> getAllProfiles() {
		return (List<Profile>) profileDao.findAll();
	}
	
	public void deleteProfileDetails(int pId) {
		profileDao.deleteById(pId);
	}
	
	public Profile getProfileById(int pId) {
		return profileDao.findById(pId).get();
	}
	
	
	
	
	
	
	public Profile updateProfile(int id, Profile profile) throws UserNotFoundException {
        Optional<Profile> optionalProfile = profileDao.findById(id);
        if (optionalProfile.isPresent()) {
            Profile existingProfile = optionalProfile.get();
            existingProfile.setFullName(profile.getFullName());
            existingProfile.setAge(profile.getAge());
            existingProfile.setGender(profile.getGender());
            existingProfile.setHeight(profile.getHeight());
            existingProfile.setContactNumber(profile.getContactNumber());
            existingProfile.setCaste(profile.getCaste());
            existingProfile.setReligion(profile.getReligion());
            existingProfile.setStar(profile.getStar());
            existingProfile.setMotherTongue(profile.getMotherTongue());
            existingProfile.setResidence(profile.getResidence());
            existingProfile.setIncome(profile.getIncome());
            existingProfile.setCitizenship(profile.getCitizenship());
            existingProfile.setEducation(profile.getEducation());
            existingProfile.setDescription(profile.getDescription());
            existingProfile.setProfileImages(profile.getProfileImages());
            return profileDao.save(existingProfile);
        }
        else
        {
        	throw new UserNotFoundException("user not found");
        }
    }
}