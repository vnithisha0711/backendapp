package com.matrimony.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {

}
