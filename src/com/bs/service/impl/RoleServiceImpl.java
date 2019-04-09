package com.bs.service.impl;

import java.util.List;

import javax.annotation.Resource;





import org.springframework.stereotype.Service;

import com.bs.dao.RoleDao;
import com.bs.entity.Role;
import com.bs.service.RoleService;


@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;
	
	public void add(Role role) {
		roleDao.save(role);
	}

	public void delete(Role role) {
		roleDao.delete(role);
	}

	public void update(Role role) {
		roleDao.update(role);
	}

	public Role findById(int id) {
		return roleDao.getById(id);
	}
	

	public List<Role> search(String str) {
		return roleDao.query(str);
	}



}
