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
