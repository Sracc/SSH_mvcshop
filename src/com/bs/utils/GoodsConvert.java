package com.bs.utils;
import org.apache.commons.beanutils.Converter;

import com.bs.entity.Goods;


public class GoodsConvert implements Converter {

	public Object convert(Class targetClass, Object value) {
		Goods goods =null;
		if (targetClass == Goods.class){
			 goods = new Goods();
			 goods.setId(Integer.parseInt((String)value));
		}
		return goods;
	}
}

