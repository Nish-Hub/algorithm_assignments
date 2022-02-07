
public class StringMatchWithSpecialCharacters {

	public static void main(String[] args) {
		
		String dbString = "ab$c$efr*";
		String strToMatch = "ab c efr ";
		
		// char array approach with space and special character positioned at same place 
		System.out.println(matchUsingCharArray(dbString.toCharArray(),strToMatch.toCharArray()));
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
}
