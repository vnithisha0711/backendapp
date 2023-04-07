package com.matrimony.dao;

import org.springframework.data.repository.CrudRepository;

import com.matrimony.entity.Role;

public interface RoleDao extends CrudRepository<Role, String> {

}
