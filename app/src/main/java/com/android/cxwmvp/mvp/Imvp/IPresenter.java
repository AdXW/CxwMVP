package com.android.cxwmvp.mvp.Imvp;
/*
 * @创建者     xw_12138
 * @创建时间   2018/5/7
 * @描述       P层
 */

public interface IPresenter<T extends IView> {

	/**
	 * 关联P与V（绑定，VIEW销毁适合解绑）
	 */
	void attachView(T view);

	/**
	 * 取消关联P与V（防止内存泄漏）
	 */
	void detachView();


}
