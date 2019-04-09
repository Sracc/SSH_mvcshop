package com.bs.utils;

import org.apache.commons.beanutils.Converter;

import com.bs.entity.User;

public class UserConvert implements Converter {

	public Object convert(Class targetClass, Object value) {
		User user = null;
		if (targetClass == User.class) {
			user = new User();
			user.setId(Integer.parseInt((String) value));
		}
		return user;
	}
}
