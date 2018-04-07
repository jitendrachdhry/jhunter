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

		/* 
		 * Start comparing from end of the string.
		 */
		int s1Length = s1.length(), s2Length = s2.length(), s1Idx=s1Length-1, s2Idx=s2Length-1;

		while(s1Idx>=0 ){ 
			if(s1Idx>0 && (s1.charAt(s1Idx-1) == '\\' && s1.charAt(s1Idx) == 'b')){
				if(s1Idx == 1) s1Idx = -1; /* We have only first 2 element (\b) in array so set it to -1 only*/
				else s1Idx -=3; /* Remove 3 char from string for \b */
			} else if(s1Idx>0 && (s1.charAt(s1Idx-1) == '\\' && s1.charAt(s1Idx) == 'c')){
				s1Idx -=2;
				if(s1Idx >=0 && Character.toUpperCase(s1.charAt(s1Idx)) == s2.charAt(s2Idx)){
					s1Idx--;
					s2Idx--;
				}else 
					break;
			}else if(s1.charAt(s1Idx) == s2.charAt(s2Idx)){
				s1Idx--; s2Idx--; continue; }
			else break;
		}
		if(s1Idx == -1 && s2Idx == -1)
			return true;
		return false;
	}
	
	/*
	 	* Given two strings - S1 and S2. 
		* Arrange the characters of S1 in same alphabetical order as the characters of S2. 
		* If a character of S1 is not present in S2 - such characters should come at the end of 
		* the result string, but make sure to retain the order of such characters 
		* Case sensitivity is irrelevant 
		* e.g. S1 = "Google", S2 = "dog" 
		* Output = "ooggle" 
		* 
		* e.g. S1 = "abcdedadf", S2 = "cae" 
		* Output = "caaebdddf" 
		* 
		* Note: 
		* 1. Assume both string have only a-z characters.
		* 2. Assume String S2 have distinct char, no repeated char allowed.
	*/
	public static String arrange1stStringBasedOn2ndString(String s1, String s2) {
		if(s1==null || s2 == null ) return null;
		StringBuilder resStr = new StringBuilder();
		
		int s1Len = s1.length(), s2Len = s2.length();
		
		//Create array of 26 chars to store repeated char count in S1.
		byte s1alpha[] = new byte[26];		
		for(int i=0; i<s1Len; i++)
			s1alpha[s1.charAt(i) - 'a']++;
		
		//Arrange the characters of S1 in same alphabetical order as the characters of S2. 
		for(int i=0; i<s2Len; i++){
			if(s1alpha[s2.charAt(i) - 'a'] != 0) {
				for(int j=0; j<s1alpha[s2.charAt(i) - 'a']; j++)
					resStr.append(s2.charAt(i));
				// Init with -1 as No need to consider this char in next loop
				s1alpha[s2.charAt(i) - 'a'] = -1; 
			}
		}
		
		//Loop to add character of S1 is not present in S2.
		for(int i=0; i<s1Len; i++)
			if(s1alpha[s1.charAt(i) - 'a'] != -1)
				resStr.append(s1.charAt(i));
		
		return resStr.toString();
	}
}
