/*
Problem statement : Binary Search In Sorted Array
Given a sorted array of distinct integers and an element K,  return index of K in the array (location where it is found); 
If K is not there in array, return -1.
Expected Time Complexity : O(log2N)
*/
/*
The data is the array size . When it was not sorted , we followed the approach of lets find if its in the 
first index and rest the the array is taken care of by the recursion

Now in binary , we break the array into two halves each time . The first time you search it , we need to check which part to check ,
if the element is in the mid , we return the result, else we recursively/iteratively find the element in the left or right part . 

Now the benefit here is again , you need to parameterise the iterative method with arr,k,low,high .
mid is calculated inside so we need not to send this . Hence we need a helper function here . 
*/
// THIS CODE IS NOT WORKING . RETURNS A WRONG VALUE : FIND THE ERROR !!! 
/*

*/

int findingIdx(int arr[], int k) {
    // TODO:  Return Index of unique element
  int l=0,h=arr.length-1;
  int mid=(l+h)/2;
  int index=0;

if(k>arr[mid]) // shift right
    {
      //l=mid+1;
  		findingIdxIterative(arr,k,mid+1,h);  // this function gives an int return which must be returned as an
  // index . so you can either save this in index or return this value
  return findingIdxIterative(arr,k,mid+1,h);
    }
    else if(k<arr[mid]) // shift left
    {
      //h=mid-1;
     findingIdxIterative(arr,k,l,mid-1);
    }
    else   // when items match
      return mid;
  
   return  index;
}
//int findingIdxIterative(int arr[],int k)
int findingIdxIterative(int arr[],int k,int l,int h)
{
  int mid=(l+h)/2;
  
  while(l<=h)
  {
    mid=(l+h)/2;
	if(k>arr[mid]) // shift right
    {
      l=mid+1;
    }
    else if(k<arr[mid]) // shift left
    {
      h=mid-1;
    }
    else   // when items match
      return mid;
  }
  return -1;
}
