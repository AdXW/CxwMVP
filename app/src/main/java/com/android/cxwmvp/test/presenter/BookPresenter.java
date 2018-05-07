package com.android.cxwmvp.test.presenter;
/*
 * @创建者     xw_12138
 * @创建时间   2018/5/7
 * @描述       
 */

import com.android.cxwmvp.mvp.base.BasePresenter;
import com.android.cxwmvp.mvp.callback.MvpCallback;
import com.android.cxwmvp.test.model.BookModel;
import com.android.cxwmvp.test.view.BookListView;

public class BookPresenter extends BasePresenter<BookListView> {

	private BookModel mBookModel;

	public BookPresenter() {
		mBookModel = new BookModel();
	}

	public void loadBooks() {
		System.out.println("第二步调用model方法--成功--开始调用model获取数据");
		getMvpView().showDialog();
		mBookModel.getBookList(new MvpCallback() {
			@Override
			public void onSuccess(String data) {
				System.out.println("第四步接收返回数据--成功");
				getMvpView().getBookList(data);
				getMvpView().hideDialog();
			}

			@Override
			public void onFailure(int code, String msg) {
				System.out.println("第四步接收返回数据--失败");
				getMvpView().getFailData(code, msg);
				getMvpView().hideDialog();
			}
		});
	}
}
