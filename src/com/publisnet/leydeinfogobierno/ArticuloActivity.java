/*
 Copyright (c) 2014 Mariano Ramirez

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial
 portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH
 THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.publisnet.leydeinfogobierno;


import java.util.HashMap;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.Spanned;
import android.annotation.TargetApi;
import android.os.Build;

public class ArticuloActivity extends ActionBarActivity {
	public static final String ARG_ARTICULO_NUMBER = "art";
	public static final String ARG_CAPITULO_NUMBER = "cap";
	public static final String ARG_TIULO_NUMBER = "titulo";
	private AdView ad;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.articulo);
		 
		 ad = new AdView(this, AdSize.BANNER, "a152e6f4cb5b418");
			
		LinearLayout layout = (LinearLayout)findViewById(R.id.admobart);
		// Iniciar una solicitud genérica para cargarla con un anuncio
	    ad.loadAd(new AdRequest());
	    // Añadirle la adView
	    layout.addView(ad);
	    
	 // Show the Up button in the action bar.
	 		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	 		getSupportActionBar().setTitle(R.string.app_tittle);
	 		int artid = getIntent().getExtras().getInt(ARG_ARTICULO_NUMBER);
	 		int capid = getIntent().getExtras().getInt(ARG_CAPITULO_NUMBER);
	 		int tituid = getIntent().getExtras().getInt(ARG_TIULO_NUMBER);
	 		Log.d("preuba", "t"+tituid+"capitulo"+capid+"arts"+artid); 
	    
	    
	    
	    Tracker defaultTracker = GoogleAnalytics.getInstance(this).getDefaultTracker();

		HashMap<String, String> hitParameters = new HashMap<String, String>();
		hitParameters.put("ART", ""+artid);
		hitParameters.put("CAP", ""+capid);
		hitParameters.put("TIT", ""+tituid);
		hitParameters.put("SCREEN", "Articulo");

		defaultTracker.send(null, hitParameters);
	    
		 
		
    	
		int capituloid = getResources().getIdentifier("t"+tituid+"capitulo"+capid,"array",getApplicationContext().getPackageName());
		String titletext = getResources().getStringArray(capituloid)[artid];
		if(titletext.indexOf('-')>0){
			TextView arttitle = (TextView)findViewById(R.id.arttitle);
		    arttitle.setText(titletext.split("-")[1]);
		}

        int capitulosid = getResources().getIdentifier("t"+tituid+"capitulo"+capid+"arts","array",getApplicationContext().getPackageName());
		Spanned spanned = Html.fromHtml(getResources().getStringArray(capitulosid)[artid],null, new MyTagHandler());
	    TextView art = (TextView)findViewById(R.id.artcontent);
	    art.setText(spanned);
	    if(android.os.Build.VERSION.SDK_INT >=android.os.Build.VERSION_CODES.HONEYCOMB){
	    	text(art);
	    }
	    
	   

	}
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void text(TextView as){
		as.setTextIsSelectable(true);
	}
	@Override
	protected void onStart() {
		EasyTracker.getInstance().activityStart(this);  
		super.onStart();
	}
	@Override
	protected void onStop() {
		EasyTracker.getInstance().activityStop(this);  
		super.onStop();
	}
	@Override
	  public void onDestroy() {
	    ad.destroy();
	    super.onDestroy();
	  }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
