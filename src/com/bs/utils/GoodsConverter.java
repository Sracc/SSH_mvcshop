package com.bs.utils;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.bs.entity.Goods;

public class GoodsConverter extends StrutsTypeConverter{
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String dateString = values[0];
		Goods goods =null;
		if (toClass == Goods.class){
			 goods = new Goods();
			 goods.setId(Integer.parseInt((String)dateString));
		}
		return goods;
	}

	@Override
	public String convertToString(Map context, Object o) {
		return ((Goods)o).toString();
	}

}
