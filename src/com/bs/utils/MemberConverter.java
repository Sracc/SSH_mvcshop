package com.bs.utils;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.bs.entity.Member;

public class MemberConverter extends StrutsTypeConverter{
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String dateString = values[0];
		Member member =null;
		if (toClass == Member.class){
			 member = new Member();
			 member.setId(Integer.parseInt((String)dateString));
		}
		return member;
	}

	@Override
	public String convertToString(Map context, Object o) {
		return ((Member)o).toString();
	}

}
