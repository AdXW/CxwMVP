package com.android.cxwmvp.test.model;
/*
 * @创建者     xw_12138
 * @创建时间   2018/5/7
 * @描述       
 */

import com.android.cxwmvp.httputils.ResultCallback;
import com.android.cxwmvp.mvp.base.BaseModel;
import com.android.cxwmvp.mvp.callback.MvpCallback;

public class BookModel extends BaseModel<String> {

	@Override
	public void requestGetApi(String url, final MvpCallback<String> mvpCallback) {

		mOkHttpUtils.getProgressResponse(new ResultCallback() {
			@Override
			public void onResponseResult(String myResult) {
				System.out.println("第三步调用网络方法获取数据--成功");
				mvpCallback.onSuccess(myResult);
			}

			@Override
			public void onResponseFailed(int code, String msg) {
				System.out.println("第三步调用网络方法获取数据--失败");
				mvpCallback.onFailure(code, msg);
			}
		}, null, url);
	}

	/*@Override
	public void requestGetApi(String url, final ResultCallback resultCallback) {
		mOkHttpUtils.getProgressResponse(new ResultCallback() {
			@Override
			public void onResponseResult(String myResult) {
				System.out.println("第三步调用网络方法获取数据--成功");
				resultCallback.onResponseResult(myResult);
			}

			@Override
			public void onResponseFailed(int code, String msg) {
				System.out.println("第三步调用网络方法获取数据--失败");
				resultCallback.onResponseFailed(code, msg);

			}
		}, null, url);
	}*/
}
