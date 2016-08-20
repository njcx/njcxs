package com.example.njcx;

import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

@SuppressLint("SetJavaScriptEnabled") 
public class MainActivity extends Activity {
	private long exitTime = 0;
	private WebView webView;
    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        webView=(WebView)findViewById(R.id.webView);
        webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
       
        return false;
         }
        });
       webView.loadUrl("file:///android_asset/index.html");
        setContentView(webView);
        Handler handler = new Handler(); 

        Runnable updateThread = new Runnable(){  
                	public void run(){  
                		webView.loadUrl("http://www.njcxs.cc");
                        }    
            
                	};
        handler.postDelayed(updateThread, 1000);
        setContentView(webView);
        
    }
    public void onBackPressed() {
        if (webView.canGoBack()) {
    	webView.goBack();
    	 } else {
    	if ((System.currentTimeMillis() - exitTime) > 2000) {
    	Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
    	exitTime = System.currentTimeMillis();
    	} else {
    	super.onBackPressed();
    	}}}
  
}
