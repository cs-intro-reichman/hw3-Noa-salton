/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		//String[] arrList1 = preProcess(str1).split("");
		String str1ProProcess =  preProcess(str1);
		String proPreProcessSTR2 = preProcess(str2);
		if (proPreProcessSTR2.length() != str1ProProcess.length()){ return false;}
		boolean bool = true;
		for (int i=0; i < proPreProcessSTR2.length(); i++){
			if (str1ProProcess.indexOf(proPreProcessSTR2.charAt(i)) == -1){bool = false;}
		}
		return bool;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String lowerCase = "";
		for (int i = 0 ; i < str.length(); i++){if (Character.isLetter(str.charAt(i))){lowerCase += str.charAt(i);}}
		return lowerCase.toLowerCase();
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newstr = preProcess(str);
		String arrANAGRAM [] = new String[newstr.length()];
		String output = ""; 
		for (int k = 0; k < arrANAGRAM.length; k++){arrANAGRAM[k] = "";} 
		for (int i=0; i<newstr.length(); i++){
			int rand = (int)(Math.random() * ((arrANAGRAM.length-1) + 1));
			if (arrANAGRAM[rand] == ""){arrANAGRAM[rand] = arrANAGRAM[rand] += newstr.charAt(i);}
			else{ while(arrANAGRAM[rand] != ""){rand = (int)(Math.random() * ((arrANAGRAM.length-1) + 1));}arrANAGRAM[rand] += newstr.charAt(i);}}
		for (int j=0; j<arrANAGRAM.length; j++){output += arrANAGRAM[j];}
		return output;
	}
}
