package com.android.cxwmvp.mvp.base;
/*
 * @创建者     xw_12138
 * @创建时间   2018/5/7
 * @描述       
 */

import com.android.cxwmvp.httputils.OkHttpUtils;
import com.android.cxwmvp.httputils.ResultCallback;
import com.android.cxwmvp.mvp.callback.MvpCallback;

import java.util.Map;

public class BaseModel<T> {

	protected OkHttpUtils mOkHttpUtils = OkHttpUtils.SINGLEOKHTTPSIMP;

	//数据请求参数
	private String[] mParams;

	public BaseModel params(String... args) {
		mParams = args;
		return this;
	}

	//执行GET请求
	public void requestGetApi(String url, MvpCallback<T> mvpCallback) {

	}

	//执行GET请求
	public void requestGetApi(String url, ResultCallback resultCallback) {

	}

	//这行POST请求
	public void requestPostApi(String url, Map params, MvpCallback mvpCallback) {

	}

}
