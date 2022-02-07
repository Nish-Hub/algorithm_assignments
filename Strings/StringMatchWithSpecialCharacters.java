
public class StringMatchWithSpecialCharacters {

	public static void main(String[] args) {
		
		//String dbString = "ab$c$efr*%";
		String dbString = "a$$^ac";
		String strToMatch = "ab c efr ";
		
		// char array approach with space and special character positioned at same place 
		System.out.println(matchUsingCharArray(dbString.toCharArray(),strToMatch.toCharArray()));
		
		String strToMatchWithoutSpaces = "aa        c";
		// char array approach with space and special character positioned at same place 
		System.out.println(matchUsingCharArrayWithoutSpaces(dbString.toCharArray(),strToMatchWithoutSpaces.toCharArray()));
				
	}
	
	public static boolean matchUsingCharArray(char[] dbString,char[] strToMatch) {
		boolean isMatch=true;
		for(int i=0;i<dbString.length && isMatch;i++) {
			
			if(Character.isAlphabetic(dbString[i]) && Character.isAlphabetic(strToMatch[i])) {
				if(dbString[i]==strToMatch[i])
					continue;
				else {
					isMatch=false;
					break;
				}
			}
			//if dbString[i] is not alphabet , we continue till end of loop
		}
		
		return isMatch;
	}
	
	public static boolean matchUsingCharArrayWithoutSpaces(char[] dbString,char[] strToMatch) {
		boolean isMatch=true;
		int indexStrToMatch=0;
		int i=0;
		for(;i<dbString.length && isMatch;i++) {
			
			/**
			 * Case 0: if we have exhausted all the characters in the strToMatch, then only break if we get a character
			 * in the first string
			 */
			if(indexStrToMatch==strToMatch.length) {
				if(Character.isAlphabetic(dbString[i])){
					isMatch=false;
					break;
				}else
					continue;
					
			}
			
			/**
			 * Case 1: Both characters are alphabets , then compare and increase the index
			 */
			else if(Character.isAlphabetic(dbString[i]) && Character.isAlphabetic(strToMatch[indexStrToMatch]) ) {
				if(dbString[i]==strToMatch[indexStrToMatch]) {
					indexStrToMatch++;
				}
				else {
					isMatch=false;
					break;
				}
				
			/**
			 * Case 2: dbString has alphabet but strToMatch has non alphabet , we hold the pointer of i by decreasing it
			 *  and increasing position of strToMatch 	
			 */
			}else if(Character.isAlphabetic(dbString[i]) && !Character.isAlphabetic(strToMatch[indexStrToMatch])) {
				i--;
				indexStrToMatch++;
			}
			
			/**
			 * Case 3: dbString has non alphabet and strToMatch has non alphabet , we increase position of strToMatch 	
			 */
			else if(!Character.isAlphabetic(dbString[i]) && !Character.isAlphabetic(strToMatch[indexStrToMatch])) {
				indexStrToMatch++;
			}
			
			/**
			 * Case 4: dbString has non alphabet and strToMatch has alphabet , we do nothing 	
			 */
			
		}
		
			
		return isMatch;
	}
}
