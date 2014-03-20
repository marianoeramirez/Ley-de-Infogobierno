package com.publisnet.leydeinfogobierno;

import java.util.HashMap;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;



@SuppressLint("ValidFragment")
public class MainActivity extends ActionBarActivity implements OnNavigationListener {
	public ActionBar actionBar;
	private AdView ad;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ad = new AdView(this, AdSize.BANNER, "a152e6f4cb5b418");
		
		LinearLayout layout = (LinearLayout)findViewById(R.id.admob);
		// Iniciar una solicitud genérica para cargarla con un anuncio
	    ad.loadAd(new AdRequest());
	    // Añadirle la adView
	    layout.addView(ad);
		actionBar = getSupportActionBar();
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setTitle(R.string.app_tittle);
		
		
		
		final String[] dropdownValues = getResources().getStringArray(R.array.string_array_name);

	    // Specify a SpinnerAdapter to populate the dropdown list.
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(actionBar.getThemedContext(),
	        android.R.layout.simple_spinner_item, android.R.id.text1,
	        dropdownValues);

	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

	    // Set up the dropdown list navigation in the action bar.
	    actionBar.setListNavigationCallbacks(adapter, this);
	}
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putInt("tab", actionBar.getSelectedNavigationIndex());
		super.onSaveInstanceState(outState);
	}
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		actionBar.setSelectedNavigationItem(savedInstanceState.getInt("tab",0));
		super.onRestoreInstanceState(savedInstanceState);
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
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		
			
		
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_list, menu);
	    
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onNavigationItemSelected(int position, long id) {
		Tracker defaultTracker = GoogleAnalytics.getInstance(this).getDefaultTracker();

		HashMap<String, String> hitParameters = new HashMap<String, String>();
		hitParameters.put("HITITEM", "menu"+position);
		hitParameters.put("SCREEN", "MENU");

		defaultTracker.send(null, hitParameters);
		
		if(position==0){
			Fragment fragment = new HomeFragment();
		    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
		}else{
			Fragment fragment = new CapituloActivity();
		    Bundle args = new Bundle();
		    args.putInt(CapituloActivity.ARG_SECTION_NUMBER, position);
		    
		    fragment.setArguments(args);
		    FragmentTransaction f = getSupportFragmentManager().beginTransaction();
		    f.replace(R.id.container, fragment);
		    f.commit();
		    
		}
	    return true;
	}
	
}
