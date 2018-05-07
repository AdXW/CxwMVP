package com.android.cxwmvp.http;
/*
 * @创建者     xianwei
 * @创建时间   2018/4/17
 * @描述       
 */

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.KeyEvent;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.cxwmvp.R;

public class HttpDialog extends Dialog implements DialogInterface.OnKeyListener {

	private String message = "";

	private TextView mTextView;
	private ProgressBar mProgressView;

	public HttpDialog(Context context) {
		this(context, R.style.DialogStyle_1);
		setCanceledOnTouchOutside(false);
	}

	public HttpDialog(Context context, int theme) {
		super(context, theme);
		setContentView(R.layout.http_dialog);
		initialViews();
		setOnKeyListener(this);
	}

	private void initialViews() {
		mTextView = findViewById(R.id.dialog_text);
		mProgressView = findViewById(R.id.progressView);
	}


	public void setMessage(String message) {
		this.message = message;
		mTextView.setText(message);
	}

	public void setColor() {
		mTextView.setTextColor(Color.RED);
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			if (mOnKeyBackListener != null) {
				mOnKeyBackListener.keyBack();
			}
		}
		return false;
	}

	onKeyBackListener mOnKeyBackListener;

	public void setOnKeyBackListener(onKeyBackListener listener) {
		mOnKeyBackListener = listener;
	}

	public interface onKeyBackListener {
		void keyBack();
	}

}
