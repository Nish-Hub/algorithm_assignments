PROBLEM STATEMENT	Given a sorted array of integers where some values might be repeated and an element K,  return index of first occurance of K in the array (location where it is found); Return -1 if it is not found.
INPUT FORMAT	Line 1:  Integer T - Number of test cases.
Each test case consists of following lines:
Test Case Line 1:  Integer N - Number of elements in array.
Test Case Line 2:  N space separated integers representing array elements.
Test Case Line 3:  Integer Q - Number of queries on array.
Test Case Line 4:  Q space separated integers K1 K2 ... KQ for which we need to return the index.
OUTPUT FORMAT	For each test case print a separate line of output containing Q space separated indices of array for each given Query integer Ki
CONSTRAINTS	1 <= T <= 10
INT_MIN <= A[i], Ki <= INT_MAX
0 <= N, Q <= 105
COMPLEXITIES	Expected Time Complexity : O(log2N)
Allowed Space Complexity: O(N), Recursion Call Stack

SAMPLE INPUT	SAMPLE OUTPUT	EXPLANATION
2
10
0 1 5 5 5 5 9 9 10 10
6
0 1 5 9 10 16
6
-21 -12 2 99 101 128
3
-20 100 101

0 1 2 6 8 -1
-1 -1 4

Self explanatory
Test Cases Results
TestCaseID	Result	Expected	Your Output	Exception
1	true	-1 0 -1
0 1 2 6 8 -1
-1 -1 4	-1 0 -1 
0 1 2 6 8 -1 
-1 -1 4 
2	true	0 -1 10 -1 -1 -1	0 -1 10 -1 -1 -1 
Example Input - Output
firstOccuranceIdx([0, 2, 9, 9, 9, 9, 15], 9 ) => 2
firstOccuranceIdx([0, 12, 25], 11) => -1
  
 # Approach 1
  
int firstOccuranceIdx(int arr[], int k) {
    // TODO:  Return Index of unique element
  if(null == arr)
    return -1 ;
  
  int res = findingIdx(arr,k);
  
  if(res == -1 || res ==0)
    return res;
  
  int firstIndex = res;
  for( int i=(res-1);i>=0;i--){
   		
    if(arr[i]==k)
      firstIndex=i;
    else
      break ;
  }
  return firstIndex ; 
}
int findingIdx(int arr[], int k) {
  //0, 12, 25 , 11
  if(null == arr)
    return -1;
  
  // TODO:  Return Index of unique element
  int start =0; // 0
  int end = arr.length -1 ; // 2
  int result =-1 ;
  
  while((end - start)>=0){ // 2-0 > 0, 0-0 > 0 , false
    
    int mid = ((end - start) >> 1) + start ; // 0-0 / 2 + 0 = 0
    
    if(arr[mid] == k){ // arr[1] = 12 == 11 ? , false
      result = mid ; 
      break;
    }
    
  	if(arr[mid] > k) // arr[1] = 12>11 ? , true
      	 end = mid -1 ;
    else
      	 start = mid +1 ;
     
  }
  

   return result ;

}
  
