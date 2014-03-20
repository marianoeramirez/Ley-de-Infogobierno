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

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class CapituloActivity extends Fragment {
	public static final String ARG_SECTION_NUMBER = "1";
	//AdView ad = new AdView(this, AdSize.BANNER, "a152e6f4cb5b418");
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		
		View rootView = (ScrollView)inflater.inflate(R.layout.fragment, container, false);
        final int i = getArguments().getInt(ARG_SECTION_NUMBER);
        ((TextView)rootView.findViewById(R.id.titulo)).setText(getResources().getStringArray(R.array.leyes_titulos)[i]);
        
        
        //carga de articulos dentro de mismo titulo
    	int articulos = getResources().getIdentifier("t"+i+"capitulo0","array",getActivity().getApplicationContext().getPackageName());
    	//int articulosid = getResources().getIdentifier("t"+i+"arts","array",getActivity().getApplicationContext().getPackageName());

    	if (articulos != 0 ){
    		final String[] dropdownValues = getResources().getStringArray(articulos);
            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            int position = 0;
            for(String arts : dropdownValues){
            	Button art = new Button(getActivity().getApplicationContext());
            	art.setText(arts);
            	final int pos = position;
            	art.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						Bundle sendBundle = new Bundle();
			            sendBundle.putInt(ArticuloActivity.ARG_ARTICULO_NUMBER, pos);
			            sendBundle.putInt(ArticuloActivity.ARG_TIULO_NUMBER, i);
			            sendBundle.putInt(ArticuloActivity.ARG_CAPITULO_NUMBER,  0);
						Intent intent = new Intent(getActivity().getApplicationContext(),ArticuloActivity.class);
						intent.putExtras(sendBundle);
			            startActivity(intent);			            
					}
				});
            	((LinearLayout) rootView.findViewById(R.id.ley)).addView(art,lp);
            	position += 1;
            }
            
    		
    	}
        //carga de capitulos dentro del tituo
        int[] capitulos = ley.getCapitulos(i);
        if( capitulos != null){
	        int capitulosid = getResources().getIdentifier("titulo"+i,"array",getActivity().getApplicationContext().getPackageName());
	        
	        
	        for(int cap : capitulos){
	        	Log.d("capitulo", "cap"+cap);
	        	View listview = (LinearLayout)inflater.inflate(R.layout.capitulo, container, false);
	        	int capituloid = getResources().getIdentifier("t"+i+"capitulo"+cap,"array",getActivity().getApplicationContext().getPackageName());
	        	LinearLayout list = (LinearLayout)listview.findViewById(R.id.listart);
	            
	        	
	        	
	        	
	        	String titulocapitulo = getResources().getStringArray(capitulosid)[cap-1];
	        	if(titulocapitulo.indexOf('-') > 0){
	        		String[] c = titulocapitulo.split("-");
	        		((TextView) listview.findViewById(R.id.numeracioncapitulo)).setText(c[0]);
	        		if(c.length > 1)
	        			((TextView) listview.findViewById(R.id.titulocapitulo)).setText(c[1]);
	        	}else{
	        		((TextView) listview.findViewById(R.id.numeracioncapitulo)).setText("CAPÍTULO "+RomanNumerals(cap));
	        		((TextView) listview.findViewById(R.id.titulocapitulo)).setText(titulocapitulo);
	        	}
	            
	            
	            final String[] dropdownValues = getResources().getStringArray(capituloid);
	            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	            final int capi = cap;
	            int position = 0;
	            for(String arts : dropdownValues){
	            	Button art = new Button(getActivity().getApplicationContext());
	            	art.setText(arts);
	            	final int pos = position;
	            	art.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							Bundle sendBundle = new Bundle();
				            sendBundle.putInt(ArticuloActivity.ARG_ARTICULO_NUMBER, pos);
				            sendBundle.putInt(ArticuloActivity.ARG_TIULO_NUMBER, i);
				            sendBundle.putInt(ArticuloActivity.ARG_CAPITULO_NUMBER,  capi);
							Intent intent = new Intent(getActivity().getApplicationContext(),ArticuloActivity.class);
							intent.putExtras(sendBundle);
				            startActivity(intent);			            
							
							//Fragment fragment = new ArticuloFragment();
		    			    //Bundle args = new Bundle();
		    			    //args.putInt(ArticuloFragment.ARG_ARTICULO_NUMBER, pos);
		    			    //fragment.setArguments(args);
		    			    //args.putInt(ArticuloFragment.ARG_TIULO_NUMBER, i);
		    			    //fragment.setArguments(args);
		    			    ///args.putInt(ArticuloFragment.ARG_CAPITULO_NUMBER,  capi);
		    			    //fragment.setArguments(args);
		    			    //FragmentTransaction f = getFragmentManager().beginTransaction();
		    			    //f.setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
		    			    //f.addToBackStack(null);
		    			    //f.replace(R.id.container, fragment).addToBackStack(null);
		    			    //f.commit();
						}
					});
	            	list.addView(art,lp);
	            	position += 1;
	            }
	            ((LinearLayout) rootView.findViewById(R.id.ley)).addView(listview);
	        }
    	    //ArrayAdapter<String> adapter = new ArrayAdapter<String>( getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, android.R.id.text1,dropdownValues);
    	    //list.setAdapter(adapter);
    	    
    	    
    	    
            //list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

    			//@Override
    			//public void onItemClick(AdapterView<?> parent, View view, int position,
    					//long id) { 	
    				
    			    
    				
    			//}
    		//});
            
        }
        
        //LinearLayout l = new LinearLayout(getActivity().getApplicationContext());
        
        
        
        
        return rootView;		
		
	}
	public static String RomanNumerals(int Int) {
	    LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
	    roman_numerals.put("M", 1000);
	    roman_numerals.put("CM", 900);
	    roman_numerals.put("D", 500);
	    roman_numerals.put("CD", 400);
	    roman_numerals.put("C", 100);
	    roman_numerals.put("XC", 90);
	    roman_numerals.put("L", 50);
	    roman_numerals.put("XL", 40);
	    roman_numerals.put("X", 10);
	    roman_numerals.put("IX", 9);
	    roman_numerals.put("V", 5);
	    roman_numerals.put("IV", 4);
	    roman_numerals.put("I", 1);
	    String res = "";
	    for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
	      int matches = Int/entry.getValue();
	      res += repeat(entry.getKey(), matches);
	      Int = Int % entry.getValue();
	    }
	    return res;
	  }
	  public static String repeat(String s, int n) {
	    if(s == null) {
	        return null;
	    }
	    final StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < n; i++) {
	        sb.append(s);
	    }
	    return sb.toString();
	  }
}
