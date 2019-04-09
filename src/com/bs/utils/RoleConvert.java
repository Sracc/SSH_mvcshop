package com.bs.utils;

import org.apache.commons.beanutils.Converter;

import com.bs.entity.Role;

public class RoleConvert implements Converter {
	public Object convert(Class targetClass, Object value) {
		Role role = null;
		if (targetClass == Role.class) {
			role = new Role();
			role.setId(Integer.parseInt((String) value));
		}
		return role;
	}
}