package com.example.demo;



public class ErrInput  {

	public static boolean Time(String s)  {
		if(s.length()!=5)return true;
		try {
			@SuppressWarnings("unused")
			int x=Integer.valueOf(s.substring(0,2)+s.substring(3,5));
		}
		catch(NumberFormatException x) {
			return true;
		}
		if(s.charAt(2)!=':')return true;
		return false;
	}
	public static boolean Website(String s) {
		if(s.contains("https://")|s.contains("http://bit"))return false;
		return true;
	}
}