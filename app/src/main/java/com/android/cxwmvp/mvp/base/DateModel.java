package com.android.cxwmvp.mvp.base;
/*
 * @创建者     xw_12138
 * @创建时间   2018/5/8
 * @描述       
 */

public class DateModel {

	public static BaseModel request(String token) {
		//声明一个空的basemodel
		BaseModel model = null;
		try {
			//利用反射获取对应的mode对象引用
			model = (BaseModel) Class.forName(token).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return model;

	}

}
