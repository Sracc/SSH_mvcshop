package com.bs.utils;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.bs.entity.User;

public class UserConverter extends StrutsTypeConverter {
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String dateString = values[0];
		User user = null;
		if (toClass == User.class) {
			user = new User();
			user.setId(Integer.parseInt((String) dateString));
		}
		return user;
	}

	@Override
	public String convertToString(Map context, Object o) {
		return ((User) o).toString();
	}

}
