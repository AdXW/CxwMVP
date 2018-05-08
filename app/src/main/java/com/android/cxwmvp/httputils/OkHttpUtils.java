package com.android.cxwmvp.httputils;
/*
 * @创建者     xw_12138
 * @创建时间   2018/5/7
 * @描述       
 */

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.request.PostRequest;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public enum OkHttpUtils {

	/**
	 * 单例实例
	 */
	SINGLEOKHTTPSIMP;

	/**
	 * get请求有progress
	 *
	 * @param resultCallback 请求结果回调
	 * @param params         请求参数
	 * @param url            请求地址
	 */
	public void getProgressResponse(ResultCallback resultCallback,
									Map<String, String> params, String url) {
		OkGo.<String>get(url).params(params).execute(resultCallback);
	}


	/**
	 * post请求有progress
	 *
	 * @param resultCallback 请求结果回调
	 * @param params         请求参数
	 * @param url            请求地址
	 */
	public void postProgressResponse(
			ResultCallback resultCallback,
			Map<String, String> params, String url) {
		OkGo.<String>post(url).params(params).execute(resultCallback);
	}

	/**
	 * 文件下载
	 *
	 * @param url
	 * @param fileCallback
	 */
	public void downloadFile(String url, FileCallback fileCallback) {
		OkGo.<File>get(url)
				.tag(this)
				.execute(fileCallback);
	}

	/**
	 * 多张图片上传form
	 *
	 * @param params
	 * @param keyV
	 * @param resultCallback
	 */
	public void postUserPices(Map<String, String> params, Map<String, File> keyV, String url, ResultCallback resultCallback) {

		PostRequest kai = OkGo.post(url).isMultipart(true);

		Iterator i$ = keyV.keySet().iterator();

		while (i$.hasNext()) {
			String key = (String) i$.next();
			kai.params(key,
					keyV.get(key));
		}
		kai.params(params).execute(resultCallback);
	}

	/**
	 * 多组图片上传form
	 *
	 * @param params
	 * @param keyV
	 * @param resultCallback
	 */
	public void postUserPicesZ(Map<String, String> params, Map<String, List<File>> keyV, String url, ResultCallback resultCallback) {
		PostRequest kai = OkGo.post(url).isMultipart(true);

		Iterator i$ = keyV.keySet().iterator();

		while (i$.hasNext()) {
			String key = (String) i$.next();
			kai.addFileParams(key,
					keyV.get(key));
		}
		kai.params(params).execute(resultCallback);
	}

	public void getBookList(ResultCallback resultCallback) {
		Map<String, String> params = new HashMap<>();
		String url = "https://www.apiopen.top/novelApi";
		getProgressResponse(resultCallback, params, url);

	}

}
