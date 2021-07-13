/*
Sum of Elements in Array

Given an array of integers and write a function that returns sum of all elements of the array.

This is implemented using both tail and head recursion 
1. Head recursion 
4 --> 3 --> 2 --> 1

2. Tail recursion 
1 --> 2 --> 3 --> 4
then 4 --> 3 --> 2 --> 1

*/
int sumArrayElements(int a[]) {
    // TODO:  Recursive function
  //int sum=a[0];
  //sum+=sumArrayElementsIterative(a,0);
  //return sum;
//  return  sumArrayElementsHeadH(a,0);
  return  sumArrayElementsTailH(a,0,0); 
}

//Head recursion . Recursive call first , then processing the output . 
// Here we will say that i am waiting for the sum . Send it to me , i will add it to mine .
int sumArrayElementsHeadH(int a[],int start) {
    // TODO:  Recursive function
  if(start==(a.length))
    return 0;
  int sumFromOthers= sumArrayElementsHeadH(a,start+1);  // receiving data  from the rest of the list
  // processing later 
  int sum=a[start]+sumFromOthers;
 return sum;
}

//Tail recursion . Recursive call last , processing the result and sending the data down
// tail recursion passes the sum to the rest of the list , they calculate the result and return 
//back the sum
int sumArrayElementsTailH(int a[],int start,int sumFromPrev) {
    // TODO:  Recursive function
  if(start==(a.length))
    return sumFromPrev;
    
  // processing later  
  sumFromPrev+=a[start];
 int sum= sumArrayElementsTailH(a,start+1,sumFromPrev); // sending data to the rest of the list
 return sum;
}


int sumArrayElementsIterative(int a[],int start) {
  int sum=0;
  for(int i=start;i<a.length;i++)
    	sum+=a[i];
  return sum;
}
