package com.matrimony.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.entity.Profile;

@Repository
public interface ProfileDao extends CrudRepository<Profile, Integer> {

	
}