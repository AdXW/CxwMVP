package com.android.cxwmvp.httputils;
/*
 * @创建者     xw_12138
 * @创建时间   2018/5/7
 * @描述       
 */

import android.text.TextUtils;

import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

public abstract class ResultCallback extends StringCallback {

	protected ResultCallback() {
	}

	@Override
	public void onStart(Request<String, ? extends Request> request) {
		onRequestToStart();
	}

	@Override
	public void onSuccess(Response<String> response) {
		String s = response.body();
		if (!TextUtils.isEmpty(s)) {
			onResponseResult(s);
		} else {
			onResponseFailed(-2, "请求成功,但是没有数据");
		}
	}

	@Override
	public void onError(Response<String> response) {
		super.onError(response);
		try {
			onResponseFailed(-1, "请求失败");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 请求成功回调
	 *
	 * @param myResult 返回结果
	 */
	public abstract void onResponseResult(String myResult);

	/**
	 * 请求失败回调
	 */
	public abstract void onResponseFailed(int code, String msg);

	public void onRequestToStart() {

	}


}
