package com.android.cxwmvp.application;
/*
 * @创建者     xw_12138
 * @创建时间   2018/5/7
 * @描述       
 */

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.OkHttpClient;

public class MVPApplication extends MultiDexApplication {

	protected final int CONNECT_TIMEOUT = 10000;

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		MultiDex.install(this);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		new Thread(new Runnable() {
			@Override
			public void run() {
				initAPP();
			}
		}).start();
	}

	private void initAPP() {
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkGo");
		loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
		loggingInterceptor.setColorLevel(Level.INFO);
		builder.addInterceptor(loggingInterceptor);

		builder.readTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
		//全局的写入超时时间
		builder.writeTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
		//全局的连接超时时间
		builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);

		OkGo.getInstance().init(this)                       //必须调用初始化
				.setOkHttpClient(builder.build())      //建议设置OkHttpClient，不设置将使用默认的
				.setCacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)               //全局统一缓存模式，默认不使用缓存，可以不传
				.setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)  //全局统一缓存时间，默认永不过期，可以不传
				.setRetryCount(1);               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0

	}
}
