// Ques : https://mentorpick.com/classes/5fd54e256910784c40dcda22/problem/submit/59c1ccf7cf7f4121025ef1e9

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
