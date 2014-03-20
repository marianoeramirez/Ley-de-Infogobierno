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


public class ley {
	public static int[] getCapitulos(int titulo){
		switch(titulo){
		case 1:
			int[] ca = {1,2};
			return ca;
		case 2:
			int[] ca2 = {1,2,3,4,5,6,7};
			return ca2;
		case 3:
			int[] ca3 = {1,2,3};
			return ca3;
		case 4:
		case 5:
		case 6:
			return null;
		case 7:
			int[] ca4 = {1,2,3};
			return ca4;
			
		}
		return null;
		
	}

}
