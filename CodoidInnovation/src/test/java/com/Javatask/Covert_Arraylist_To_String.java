package com.Javatask;

import java.util.ArrayList;

public class Covert_Arraylist_To_String {
	//Question No.62
	 public static void main(String args[]) {
	      ArrayList<String> al = new ArrayList<String>();
	      al.add("Hello");
	      al.add("Java");
	      al.add("Selenium");
	      StringBuffer sb = new StringBuffer();
	      
	      for (String s : al) {
	         sb.append(s);
	         sb.append(" ");
	      }
	      String str = sb.toString();
	      System.out.println(str);
	   }

}
