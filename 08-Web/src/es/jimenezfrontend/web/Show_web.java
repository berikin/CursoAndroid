package es.jimenezfrontend.web;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class Show_web extends Activity {
	private WebView mWebView;

	@SuppressLint ( "SetJavaScriptEnabled" )
	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.layout_web );
		Bundle bundle = this.getIntent ().getExtras ();
		mWebView = ( WebView ) findViewById ( R.id.webview );
		mWebView.getSettings ().setJavaScriptEnabled ( true );

		mWebView.loadUrl ( bundle.getString ( "url" ) );
	}
}
