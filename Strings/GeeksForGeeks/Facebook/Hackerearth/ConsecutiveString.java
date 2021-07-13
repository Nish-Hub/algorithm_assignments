/*
Problem statement : https://www.hackerearth.com/challenge/competitive/code-monk-array-strings/algorithm/chandu-and-consecutive-letters/
*/

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
class LLNode
{
    char data;
    LLNode next;
    LLNode(char data)
    {
        this.data=data;
        next=null;
    }
}


public class ConsecutiveString {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here

    }
    
//Using set iterative    
   String insertInStack(String str)
    {
        Set<String> ss=new LinkedHashSet<String>(str.length());
        
        for(int i=0;i<str.length();i++)
        {
        	ss.add(String.valueOf(str.charAt(i)));
        }
        
      //  char[] arr=new char[ss.size()];
      //  char[] arr2=(char[])ss.toArray(new char[ss.size()]);
    //    String[] movieArray = ss.toArray(new String[ss.size()]);
      /*  for(int i=0;i<ss.size();i++)
            arr[i]=ss.g;*/
        int i=0;
       char[] arr=new char[ss.size()]; 
       for(String s:ss)
       {
    	   arr[i++]=s.charAt(0);
       }
            
        return new String(arr);    
    }
//Using char[] iterative
  String insertInArray(String str)
    {
        char[] arr=new char[str.length()];
        char temp;
        for(int i=0,j=0;i<arr.length && j<str.length();i++)
            {
                temp=str.charAt(j);
                arr[i]=temp;
                while(true)
                {
                    if(str.charAt(j+1)==(temp)) // if next 
                                       //char matches , then move j right side
                    {
                        j++;
                    }
                    else if (str.charAt(j+1)!=(temp)) // if next char
                    {                               // doesnt match , shift j 
                                                    // one right side 
                        j++;
                        break;
                    }
                    
                }
                
            }
            
        return new String(arr);    
    }

// Using linkedlist iterative
String insertIntoLinkedList(String str)
{
  //  char[] arr=str.toCharArray();
    LLNode head=null;
    head=new LLNode(str.charAt(0));
    LLNode temp=head,curr=null;
    for(int i=1;i<str.length();i++)
    {
        temp.next=new LLNode(str.charAt(i));
        temp=temp.next;
    }
    char tmp;
    temp=head;
    while(temp != null)
    {
        tmp=temp.data;
        if(temp.next != null)
            curr=temp.next;
        else    // this means we have reached the last node and we can break
            break;
        while(true)
        {
            if(tmp==curr.data) // delete the next matching node
            {
                if(curr.next !=null)
                {
                curr=curr.next;
                temp.next=curr;
                }
                else 
                {
                temp.next=null;
                break;
                }
            }
            else
                break;
        }
        temp=temp.next;
    }
    
    char arr[]=new char[str.length()];
    temp=head;
    int i=0;
    while(temp != null)
    {
    	arr[i++]=temp.data;
    	temp=temp.next;
    }
	return new String(arr);
}


}
