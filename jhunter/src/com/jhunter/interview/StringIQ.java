package com.jhunter.interview;

public class StringIQ {
	/*
	 * comparison of two strings if they are the same, use o(1) space 
	 * abc \ b is equal to ab 
	 * abc \ ca equals abcA 
	 * \ b = backspace 
	 * \ c = CapsLock
	 */
	public static boolean compareString(String s1, String s2) {
		if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
			return false;

		int s1Length = s1.length(), s2Length = s2.length(), s1Idx=s1Length-1, s2Idx=s2Length-1;

		while(s1Idx>=0 && s2Idx>=0){

			if(s1.charAt(s1Idx-1) == '\\' && s1.charAt(s1Idx) == 'b'){
				s1Idx -=2;
			} else if(s1.charAt(s1Idx-1) == '\\' && s1.charAt(s1Idx) == 'c'){
				s1Idx -=2;
				if(Character.toUpperCase(s1.charAt(s1Idx)) == s2.charAt(s2Idx)){
					s1Idx--;
					s2Idx--;
				}else 
					return false;
			}else if(s1.charAt(s1Idx) == s2.charAt(s2Idx)){
				s1Idx--; s2Idx--; continue; }
		}
		if(s1Idx == -1 && s2Idx == -1)
			return true;
		return false;
	}
}
