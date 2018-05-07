package com.android.cxwmvp.mvp.callback;
/*
 * @创建者     xw_12138
 * @创建时间   2018/5/7
 * @描述       
 */

public interface MvpCallback {
	/**
	 * 数据请求成功
	 */
	void onSuccess(String data);

	/**
	 * 数据请求失败
	 */
	void onFailure(int code, String msg);
}
