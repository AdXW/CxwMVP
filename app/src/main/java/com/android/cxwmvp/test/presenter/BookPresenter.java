package com.android.cxwmvp.test.presenter;
/*
 * @创建者     xw_12138
 * @创建时间   2018/5/7
 * @描述       
 */

import com.android.cxwmvp.httputils.ModelLoc;
import com.android.cxwmvp.mvp.base.BasePresenter;
import com.android.cxwmvp.mvp.base.DateModel;
import com.android.cxwmvp.mvp.callback.MvpCallback;
import com.android.cxwmvp.test.model.BookModel;
import com.android.cxwmvp.test.view.BookListView;

public class BookPresenter extends BasePresenter<BookListView> {

	public void loadBooks() {
		getMvpView().showDialog();
		BookModel baseModel = (BookModel) DateModel.request(ModelLoc.API_GET_BOOK_LIST).params("");
		baseModel.requestGetApi("https://www.apiopen.top/novelApi", new MvpCallback<String>() {
			@Override
			public void onSuccess(String data) {
				getMvpView().hideDialog();
				getMvpView().getBookList(data);
			}

			@Override
			public void onFailure(int code, String msg) {
				getMvpView().hideDialog();
				getMvpView().getFailData(code, msg);
			}
		});


		/*baseModel.requestGetApi("https://www.apiopen.top/novelApi", new ResultCallback() {
			@Override
			public void onRequestToStart() {
				getMvpView().showDialog();
			}

			@Override
			public void onResponseResult(String myResult) {
				getMvpView().hideDialog();
				getMvpView().getBookList(myResult);
			}

			@Override
			public void onResponseFailed(int code, String msg) {
				getMvpView().hideDialog();
				getMvpView().getFailData(code, msg);
			}
		});*/

	}


}
