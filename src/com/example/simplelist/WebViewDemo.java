package com.example.simplelist;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class WebViewDemo extends Activity implements AdListener {

	//private WebView webView;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
 
		super.onCreate(savedInstanceState);
 	    setContentView(R.layout.webview);
 	    
 	    AdView adView = null; 
		String ad_type = getIntent().getStringExtra("ad_type"); 

		String[] ad_id = getResources().getStringArray(R.array.adunit_id); 
		int[] ad_w = getResources().getIntArray(R.array.adunit_width);
		int[] ad_h = getResources().getIntArray(R.array.adunit_height); 

		if (ad_type.matches("Simple Banner")) {			
			adView = new AdView(this, new AdSize(ad_w[0],ad_h[0]), ad_id[0]); 
		} else if (ad_type.matches("Graphical Interstitial")) {
			adView = new AdView(this, new AdSize(ad_w[1],ad_h[1]), ad_id[1]); 
		} else if (ad_type.matches("3rd Party Rich Media")) {
			adView = new AdView(this, new AdSize(ad_w[2],ad_h[2]), ad_id[2]); 
		} else if (ad_type.matches("AdSense Backfill")) {
			adView = new AdView(this, new AdSize(ad_w[3],ad_h[3]), ad_id[3]); 
		} else if (ad_type.matches("AdMob Backfill")) {
			//adView = new AdView(this, AdSize.BANNER, "a14d530a19acd63");
			adView = new AdView(this, new AdSize(ad_w[4],ad_h[4]), ad_id[4]); 
		} else if (ad_type.matches("Video Interstitial")) {
			adView = new AdView(this, new AdSize(ad_w[5],ad_h[5]), ad_id[5]); 
		} 

 	    LinearLayout layout = (LinearLayout)findViewById(R.id.wvDisplay);
 	    layout.addView(adView);
   	    AdRequest request = new AdRequest(); 
 	    request.setTesting(true); 
 	    adView.loadAd(request);
 	    ad_type = null; 
	}
		
    @Override
    public void onDismissScreen(Ad arg0) {
      Log.d("MY_LOG", "onDismissScreen", (Throwable) arg0);
    }

    @Override
    public void onLeaveApplication(Ad arg0) {
      Log.d("MY_LOG", "onLeaveApplication");

    }

    @Override
    public void onPresentScreen(Ad arg0) {
      Log.d("MY_LOG", "onPresentScreen");
      
    }

    @Override
    public void onReceiveAd(Ad arg0) {
      Log.d("MY_LOG", "Did Receive Ad");
    }

    @Override
    public void onFailedToReceiveAd(Ad arg0, ErrorCode errorCode) {
      Log.d("MY_LOG", "failed to receive ad (" + errorCode + ")");
    }
	
}
