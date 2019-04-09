package com.bs.utils;
import org.apache.commons.beanutils.Converter;

import com.bs.entity.GoodsClassify;


public class GoodsClassifyConvert implements Converter {

	public Object convert(Class targetClass, Object value) {
		GoodsClassify goodsClassify =null;
		if (targetClass == GoodsClassify.class){
			 goodsClassify = new GoodsClassify();
			 goodsClassify.setId(Integer.parseInt((String)value));
		}
		return goodsClassify;
	}
}

