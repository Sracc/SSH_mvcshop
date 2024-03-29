package com.bs.service;

import java.util.List;

import com.bs.entity.Role;



public interface RoleService extends BaseService{
	public void add(Role role);

	public void delete(Role role);

	public void update(Role role);

	public Role findById(int id);

	public List<Role> search(String str);
}