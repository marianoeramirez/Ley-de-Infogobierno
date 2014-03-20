package com.publisnet.leydeinfogobierno;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeFragment extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.activity_home, container, false);
		((TextView) rootView.findViewById(R.id.credits)).setMovementMethod(LinkMovementMethod.getInstance());
		((TextView) rootView.findViewById(R.id.credits)).setText(Html.fromHtml(getResources().getString(R.string.credits)));
		

	    
		
		return rootView;
	}


}
