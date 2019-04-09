package com.bs.utils;
import org.apache.commons.beanutils.Converter;

import com.bs.entity.State;


public class StateConvert implements Converter {

	public Object convert(Class targetClass, Object value) {
		State state =null;
		if (targetClass == State.class){
			 state = new State();
			 state.setId(Integer.parseInt((String)value));
		}
		return state;
	}
}

