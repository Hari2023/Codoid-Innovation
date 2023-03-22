package com.Javatask;

public class Reverse_String {
	//Question No.2 
	public static void main(String[] args) {

		String str = "Hari Baskar";

		char[] charArray = str.toCharArray();

		for (int i = charArray.length-1; i >= 0; i--) {
			System.out.println(charArray[i]);

		}

	}

}
