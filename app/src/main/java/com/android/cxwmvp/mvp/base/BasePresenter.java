package com.android.cxwmvp.mvp.base;
/*
 * @创建者     xw_12138
 * @创建时间   2018/5/7
 * @描述       
 */

import com.android.cxwmvp.mvp.Imvp.IPresenter;
import com.android.cxwmvp.mvp.Imvp.IView;

public class BasePresenter<T extends IView> implements IPresenter<T> {

	private T mMvpView;

	/**
	 * 获取view
	 *
	 * @return view
	 */
	public T getMvpView() {
		return mMvpView;
	}

	/**
	 * 当前的view是否存在
	 *
	 * @return true存在 false不存在
	 */
	public boolean isViewAttached() {
		return mMvpView != null;
	}

	@Override
	public void attachView(T view) {
		this.mMvpView = view;
	}

	@Override
	public void detachView() {
		this.mMvpView = null;
	}
}
