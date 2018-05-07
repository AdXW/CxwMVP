package com.android.cxwmvp.mvp.Imvp;
/*
 * @创建者     xw_12138
 * @创建时间   2018/5/7
 * @描述       MVP值V层 是所有View的基类 抽取UI公共方法 其他类可继承
 */

public interface IView {
	/**
	 * 获取数据失败
	 *
	 * @param code 错误码
	 * @param msg  错误信息
	 */
	void getFailData(int code, String msg);

	/**
	 * 显示dialog
	 */
	void showDialog();

	/**
	 * 隐藏dialog
	 */
	void hideDialog();
}
