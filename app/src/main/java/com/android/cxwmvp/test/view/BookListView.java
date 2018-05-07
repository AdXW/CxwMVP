package com.android.cxwmvp.test.view;
/*
 * @创建者     xw_12138
 * @创建时间   2018/5/7
 * @描述       
 */

import com.android.cxwmvp.mvp.Imvp.IView;

public interface BookListView extends IView {
	void getBookList(String bookList);
}
