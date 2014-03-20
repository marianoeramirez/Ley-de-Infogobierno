package com.publisnet.leydeinfogobierno;

import org.xml.sax.XMLReader;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.Html;
import android.text.Html.TagHandler;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

public class ArticuloFragment extends Fragment {
	public static final String ARG_ARTICULO_NUMBER = "art";
	public static final String ARG_CAPITULO_NUMBER = "cap";
	public static final String ARG_TIULO_NUMBER = "titulo";
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    //getActivity().setContentView(R.layout.articulo);
	    //int i = getArguments().getInt(ARG_ARTICULO_NUMBER);
	    //String co = getResources().getStringArray(R.array.titulo1art)[i];
	    //TextView art = (TextView)   getActivity().findViewById(R.id.artcontent);

	    // displaying selected product name
	    //Log.d( "passed in station information: " + i,"sd");
	    //art.setText(co);
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.articulo, container, false);
		int artid = getArguments().getInt(ARG_ARTICULO_NUMBER);
		int capid = getArguments().getInt(ARG_CAPITULO_NUMBER);
		int tituid = getArguments().getInt(ARG_TIULO_NUMBER);
		Log.d("preuba", "t"+tituid+"capitulo"+capid+"arts"+artid);
        int capitulosid = getResources().getIdentifier("t"+tituid+"capitulo"+capid+"arts","array",getActivity().getApplicationContext().getPackageName());
		Spanned spanned = Html.fromHtml(getResources().getStringArray(capitulosid)[artid],null, new MyTagHandler());
	    //WebView art = (WebView)rootView.findViewById(R.id.artcontent);
	    TextView art = (TextView)rootView.findViewById(R.id.artcontent);
	    //art.setMovementMethod(new ScrollingMovementMethod());
	    

	    //art.loadData("<meta charset=\"UTF-8\">"+getResources().getStringArray(R.array.titulo1art)[i], "text/html", "UTF-8");
	    art.setText(spanned);
	    if(android.os.Build.VERSION.SDK_INT >=android.os.Build.VERSION_CODES.HONEYCOMB){
	    	text(art);
	    }
	    	
	    //ActionBar actionBar = getParentFragment().getClass().
	    		//Ma
	    	//    actionBar.setDisplayHomeAsUpEnabled(true);
	    //MainActivity.class.
	    
	    
		return rootView;
	}
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void text(TextView as){
		as.setTextIsSelectable(true);
		
	}
	
	

}
