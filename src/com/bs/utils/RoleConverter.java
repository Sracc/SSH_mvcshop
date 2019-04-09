package com.bs.utils;


import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.bs.entity.Role;

public class RoleConverter extends StrutsTypeConverter {
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String dateString = values[0];
		Role role = null;
		if (toClass == Role.class) {
			role = new Role();
			role.setId(Integer.parseInt((String) dateString));
		}
		return role;
	}

	@Override
	public String convertToString(Map context, Object o) {
		return ((Role) o).toString();
	}

}
