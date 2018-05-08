package com.android.cxwmvp.test;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.cxwmvp.R;
import com.android.cxwmvp.activity.BaseActivity;
import com.android.cxwmvp.test.presenter.BookPresenter;
import com.android.cxwmvp.test.view.BookListView;


public class MainActivity extends BaseActivity implements BookListView {
	//进度条
	TextView text;
	private BookPresenter mBookPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView) findViewById(R.id.text);
		// 初始化Presenter
		mBookPresenter = new BookPresenter();
		mBookPresenter.attachView(this);
	}

	// button 点击事件调用方法
	public void getData(View view) {
		System.out.println("第一步点击");
		mBookPresenter.loadBooks();
	}

	@Override
	public void getBookList(String bookList) {
		text.setText(bookList);
	}

	@Override
	public void getFailData(int code, String msg) {
		text.setText(code + msg);
	}

	@Override
	public void showDialog() {
		progressDialog.show();
	}

	@Override
	public void hideDialog() {
		progressDialog.dismiss();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mBookPresenter.detachView();
		mBookPresenter = null;
	}
}
