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

import org.xml.sax.XMLReader;

import android.text.Editable;
import android.text.Html.TagHandler;

public class MyTagHandler implements TagHandler{
	boolean first= true;
	String parent=null;
	int index=1;
	@Override
	public void handleTag(boolean opening, String tag, Editable output,
	        XMLReader xmlReader) {
	
	    if(tag.equals("ul")) parent="ul";
	    else if(tag.equals("ol")) parent="ol";
	    if(tag.equals("li")){
	        if(parent.equals("ul")){
	            if(first){
	                output.append("\n\t•");
	                first= false;
	            }else{
	                first = true;
	            }
	        }
	        else{
	            if(first){
	                output.append("\n\t"+index+". ");
	                first= false;
	                index++;
	            }else{
	                first = true;
	            }
	        }   
	    }
	}
	}
