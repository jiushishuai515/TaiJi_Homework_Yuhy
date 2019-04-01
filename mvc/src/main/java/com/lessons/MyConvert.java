package com.lessons;

import org.springframework.core.convert.converter.Converter;

public class MyConvert implements Converter<String, String[]>{

	@Override
	public String[] convert(String source) {
		// TODO Auto-generated method stub
		String str[] = source.split(",");
		return str;
	}


}
