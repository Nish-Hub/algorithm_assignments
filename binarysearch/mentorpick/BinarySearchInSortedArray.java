/* Ques : https://mentorpick.com/classes/5fd54e256910784c40dcda22/problem/submit/59c1ccf7cf7f4121025ef1e9
Binary Search In Sorted Array
(author: Sandeep)
[Score: 20]
PROBLEM STATEMENT	Given a sorted array of distinct integers and an element K,  return index of K in the array (location where it is found);  If K is not there in array, return -1.
INPUT FORMAT	Line 1:  Integer T - Number of test cases.
Each test case consists of following lines:
Test Case Line 1:  Integer N - Number of elements in array.
Test Case Line 2:  N space separated integers representing array elements.
Test Case Line 3:  Integer Q - Number of queries on array.
Test Case Line 4:  Q space separated integers K1 K2 ... KQ for which we need to return the index.
OUTPUT FORMAT	For each test case print a separate line of output containing Q space separated indices of array for each given Query integer Ki
CONSTRAINTS	1 <= T <= 10
INT_MIN <= A[i], Ki <= INT_MAX
0 <= N, Q <= 108
COMPLEXITIES	Expected Time Complexity : O(log2N)
Allowed Space Complexity: O(N), Recursion Call Stack
HINT VIDEO


SAMPLE INPUT	SAMPLE OUTPUT	EXPLANATION
2
3
7 9 15
2
0 9
5
1 2 7 9 10
3
7 9 28

-1 1
2 3 -1

Self explanatory
Example Input - Output
findingIdx([-8, -7, 2, 7], -7 ) => 1
findingIdx([0, 12, 25], 11) => -1
  */

// Approach 1: Iterative approach
int findingIdx(int arr[], int k) {
  // Test Case for dry run : arr{0, 12, 25} , k=11
  if(null == arr)
    return -1;
  
  // TODO:  Return Index of unique element
  int start =0; // 0
  int end = arr.length -1 ; // 2
  int diff = end - start ; // 2-0 = 2
  
  if(diff <0) return -1;
  
  int mid = (end - start)/2 + start; // 2-0/2 + 0 = 1  . TODO : This formula simplifies to end+start/2 , then why not use it directly .
  boolean goLeft = false;
  int result =-1 ;
  
  while((end - start)>=0){ // 2-0 > 0, 0-0 > 0 , false
    
     mid = (end - start)/2 + start ; // 0-0 / 2 + 0 = 0
    
    if(arr[mid] == k){ // arr[1] = 12 == 11 ? , false
      result = mid ; 
      break;
    }
    
  	if(arr[mid] > k) // arr[1] = 12>11 ? , true
      	goLeft = true ;
    
  
  	// basis on result , calculate new end and start
    if(goLeft){
      end = mid -1 ; // left , s=s = 0, e=m-1 = 1-1 = 0
    }else
      start = mid +1 ; // right , s=m+1 , e=e
    
     
  }
  

   return result ;

}
