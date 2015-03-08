package com.ss.basecontainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.bnpppoc.R;

/**
 * The Class MessagentScreenFragment.
 */
public class MessagentScreenFragment extends Fragment implements
		OnClickListener {


	private static final String IS_CLOSE_BTN_NEEDED = "IS_CLOSE_BTN_NEEDED";

	private WebView messagantWebView;

	private Button imgCloseBtn;

	public static final String MESSAGANT_URL = "MESSAGANT_URL";

	private CloseButtonListener listener;



	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bnpff.ssc.imb.sf.shell.sdkwidget.utils.fragment.CustomVmc#onCreate
	 * (android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bnpff.ssc.imb.sf.shell.sdkwidget.utils.fragment.CustomVmc#onCreateView
	 * (android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.messagentscreeen, container,
				false);
		messagantWebView = (WebView) view.findViewById(R.id.webView);
		imgCloseBtn = (Button) view.findViewById(R.id.btnClose);
		messagantWebView.setWebViewClient(new WebViewClient() {

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
			}
			
		}

		);
		imgCloseBtn.setOnClickListener(this);
		imgCloseBtn.bringToFront();
		imgCloseBtn.setVisibility(View.INVISIBLE);
		if (getArguments() != null
				&& getArguments().getString(IS_CLOSE_BTN_NEEDED) != null
				&& "true".equals(getArguments().getString(IS_CLOSE_BTN_NEEDED))) {
			imgCloseBtn.setVisibility(View.VISIBLE);
		}
		return view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bnpff.ssc.imb.sf.shell.sdkwidget.utils.fragment.CustomVmc#onResume()
	 */
	@Override
	public void onResume() {
		super.onResume();
		messagantWebView.loadUrl(getArguments().getString(MESSAGANT_URL));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btnClose) {
			if (listener != null) {
				listener.onCloseBtnClick();
			}
			getFragmentManager().popBackStack();
		}
	}

	public void setCloseButtonListener(CloseButtonListener listener) {
		this.listener = listener;
	}

	public interface CloseButtonListener {

		public void onCloseBtnClick();
	}


}
