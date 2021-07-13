/*
Problem Statement :  https://practice.geeksforgeeks.org/problems/decode-the-string/0
Below Code is failing for the test case "56[1[a4[bccd]2[c]]]"

*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class StringDecode {
	public static void main(String[] args) {
		// code
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		while (N-- != 0) {
			String str =sc.next();   // "11[geeks]"; 
			System.out.println(new StringDecode().decodeString(str));
		}
	}
	
	// 2[ab2[ab3[b] 2[c]]]
	// 2[   ab2[   ab3[b]  2[c]  ]  ]

	String decodeString(String arr) {
        if(arr.trim().length()==0)
        return arr;
		// If there are nothing to decode , return the string directly
		if (arr.indexOf('[') == -1 || arr.indexOf(']') == -1)
			return arr;
		// Local vaiables
		StringBuffer res = new StringBuffer();
		String internal = "";
		int n = 0;
		// Parsing the string
		for (int i = 0; i < arr.length(); i++) {

			// reading all the characters which come at the start
			while (i < arr.length() && (arr.charAt(i) < 48 || arr.charAt(i) > 58)) {
				res.append(String.valueOf(arr.charAt(i++)));
			}
			// Check if we have reached the end of string
			if (i >= arr.length())
				break;
			// Converting ascii to int ascii by taking ascii of '0' as reference
			// n = arr.charAt(i) - '0'; -- works for only single digits
			n = Integer.parseInt(arr.substring(i, arr.indexOf('['))); // to
																		// extract
																		// double
																		// or
																		// more
																		// than
																		// one
																		// digit
			// The first internal string will be inside the outer [ and ]
			// brackets
			int index = arr.lastIndexOf("]");
			// Check if we have a bracket in the string else just keep on
			// looping
			if (index != -1) {
				// extract the first internal string .
				internal = arr.substring(arr.indexOf('[') + 1, arr.lastIndexOf(']'));
				// recursive function invocation to decode the internal string
				String internalStr = decodeStringRec(internal).toString(); // ab2[ab]2[c]
				// append the returned string n times
				for (int j = 0; j < n; j++) {
					res.append(internalStr);
				}
				// after the end of ] , start at the next index to check if
				// there is any other alphabet to be appended
				i = index;
			}

		}
		return res.toString();
	}

	String decodeStringRec(String arr) {

		// If there are nothing to decode , return the string directly
		if (arr.indexOf('[') == -1 || arr.indexOf(']') == -1)
			return arr;
		// Local vaiables
		StringBuffer res = new StringBuffer();
		String internal = "";
		int n = 0;
		int index = 0;
		// Parsing the string
		for (int i = 0; i < arr.length(); i++) {

			// reading all the characters which come at the start
			while (i < arr.length() && (arr.charAt(i) < 48 || arr.charAt(i) > 58)) {
				res.append(String.valueOf(arr.charAt(i++)));
			}
			// Check if we have reached the end of string
			if (i >= arr.length())
				break;
			// Converting ascii to int ascii by taking ascii of '0' as reference
			// n = arr.charAt(i) - '0'; -- works for only single digits
			n = Integer.parseInt(arr.substring(i,i+arr.substring(i).indexOf('['))); // to
																		// extract
																		// double
																		// or
																		// more
																		// than
																		// one
																		// digit
			// The first internal string will be inside the outer [ and ]
			// brackets
			index = i + 1; // arr.indexOf("]");
			// Check if we have a bracket in the string else just keep on
			// looping
			if (index != -1) {
				// extract the first internal string .
				int start = index + arr.substring(index).indexOf('[');
				int end = index + arr.substring(index).indexOf(']');
				internal = arr.substring(start + 1, end);
				// recursive function invocation to decode the internal string
				String internalStr = decodeStringRec(internal).toString(); // ab2[ab]2[c]
				// append the returned string n times
				for (int j = 0; j < n; j++) {
					res.append(internalStr);
				}
				// after the end of ] , start at the next index to check if
				// there is any other alphabet to be appended
				i = end;
			}

		}
		return res.toString();
	}

	StringBuffer decodeInternalString(String arr) {
		if (arr == null)
			return null;
		StringBuffer res = new StringBuffer();
		String internal = "";
		int n = 0;
		for (int i = 0; i < arr.length(); i++) {
			// reading all the characters which come at the start
			while (arr.charAt(i) > 48 && arr.charAt(i) < 58) {
				res.append(String.valueOf(arr.charAt(i)));
			}
			n = arr.charAt(i);
			int index = arr.lastIndexOf("]");
			internal = arr.substring(i, index - 1);
			for (int j = 0; j < n; j++) {
				res.append(decodeInternalString(internal));
			}
			i = index;
		}
		return res;
	}
}

/*
 * 
 * 
 * "3[a3[b]1[ab]]".
 * 
 * [a3[b]1[ab]] [a3[b]1[ab]] [a3[b]1[ab]]
 * 
 * a 3[b] 1[ab] a 3[b] 1[ab] a 3[b] 1[ab]
 * 
 * a bbb ab a bbb ab a bbb ab
 * 
 * result :
 * 
 * General format :
 * 
 * n1[n2[]n3[]n4[]...]
 * 
 * 1. reach the first [ 2. Save the number or integer n1 3. Look for the last ]
 * and save it as string str 3. the internal string inside [] i.e str will be
 * processed n1 times. 4. now start looking for next [ or look for next char .
 * 5. if it is a number , look for [ and ending ] . 6. process this internal
 * string also n2 times . 7. return the result. 8. if at step 4 gives an
 * alphabet and not a number , simply append this char and look for next char.
 * 
 * 
 * Test cases 1. n1[a] 2. an1[a] 3. n1[n2[a]] 4. n1[an2[a]] 5. n1[n2[a]an3[a]]
 * 6. n1[n2[a]an3[a]an4[a]] 7. n1[an2[an3[a]]] 8. an1[a]a
 * 
 * 
 * an1[bn2[a]] -->> a+ some string in between []
 * 
 * an1[bn2[a]]:= alphabet (if any) + some string in between [] ( n1[n2[a]] )
 * bn1[n2[a]] := alphabet (if any) + n1* + some string in between [] (n2[a])
 * n2[a]=alphabet (if any) + n2* { No open brackets left now }
 * 
 * 
 * Observations : 1.There is no surety if the first char is a number or an
 * alphabet 2.Reading the chars is the option in order to avoid skipping any
 * char 3.To check if any internal string is left , we need to check for the
 * open square brackets . 4.recursion can help here -> Recursive conversation
 * with me -> "See , i see a pattern here . If i find any square bracket , i
 * start looking for another square bracket and process them in the same way and
 * this repetition is ofcourse not my type. SO what i will do is , i will
 * process the string as if whats written inside isnt my area , i will give you
 * the logic for outer bracket and you run that . So i will be working on test
 * case 2 which pretty much completes all the test cases . "
 * 
 */
