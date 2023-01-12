package com.example.hrms.string.utilites;

import java.util.Locale;

;


public class StringUtils {

	public static String convertToUpperCase(String firstName) {
		Locale locale = new Locale("tr", "TR");
		return firstName.toUpperCase(locale);
	}
	
	public static String replaceCharacter(char oldCharacter, char newCharacter, String value) {
		return value.replace(oldCharacter, newCharacter);
	}
//null pointer hatası
	/*
	public static void main(String[] args) {
		String isim = "irem";
		String buyukIsim = convertToUpperCase(isim);
		System.out.println(buyukIsim);
	}

	 */
}
