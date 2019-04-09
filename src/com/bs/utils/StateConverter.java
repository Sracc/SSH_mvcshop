package com.bs.utils;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.bs.entity.State;

public class StateConverter extends StrutsTypeConverter{
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String dateString = values[0];
		State state =null;
		if (toClass == State.class){
			 state = new State();
			 state.setId(Integer.parseInt((String)dateString));
		}
		return state;
	}

	@Override
	public String convertToString(Map context, Object o) {
		return ((State)o).toString();
	}

}
