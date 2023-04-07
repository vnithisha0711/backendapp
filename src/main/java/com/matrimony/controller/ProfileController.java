package com.matrimony.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.matrimony.entity.ImageModel;
import com.matrimony.entity.Profile;
import com.matrimony.service.ProfileService;
import com.matrimony.service.UserNotFoundException;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@PreAuthorize("hasAnyRole('Admin','User')")
	@PostMapping(value={"/profile/add"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Profile addNewProfile(@RequestPart("profile") Profile profile,
			@RequestPart("imageFile")MultipartFile[] file ) {
		//return profileService.addNewProfile(profile);
		try {
			Set<ImageModel> images= uploadImage(file);
			profile.setProfileImages(images);
			return profileService.addNewProfile(profile);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}
	
	public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
		Set<ImageModel> imageModels = new HashSet<>();
		for(MultipartFile file : multipartFiles) {
			ImageModel imageModel = new ImageModel(
	     	 file.getOriginalFilename(),
	     	file.getContentType(),
	     	file.getBytes()
		);
		imageModels.add(imageModel);	
		}
		return imageModels;
	}
	@GetMapping("/getAllProfiles")
	public List<Profile> getAllProfiles(){
		return profileService.getAllProfiles();
	}
//	@DeleteMapping("/delete/profile/{id}")
//	public ResponseEntity<Void> deleteProfileById(@PathVariable("id") int id) {
//		boolean isDeleted = profileService.deleteProfileById(id);
//		if (isDeleted) {
//			return new ResponseEntity<>(HttpStatus.OK);
//			
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	@PreAuthorize("hasAnyRole('Admin','User')")
	@DeleteMapping("/deleteProfileDetails/{pId}")
	public void deleteProfileDetails(@PathVariable("pId") int pId) {
		profileService.deleteProfileDetails(pId);
	}
	
	@PreAuthorize("hasAnyRole('Admin','User')")
	 @GetMapping("/profile/{pId}")
	    public Profile getProfileById(@PathVariable("pId") int pId) {
		  return profileService.getProfileById(pId);
	       
	    }
	 
}
