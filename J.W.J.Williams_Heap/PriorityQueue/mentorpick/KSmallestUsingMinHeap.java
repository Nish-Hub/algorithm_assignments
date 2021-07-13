//QUESTION 3:  Given an array of size N, Print K values which are smallest in the entire array, duplicates as well in the array, print them in any order.

import java.util.*;
/*
For input : 11,2,13,4,500
Getting output : 
1st element smallest is  2
2st element smallest is  11
3st element smallest is  13

This is not correct output . When we are inserting 4 after 13 , it should get inserted and should remove 13 . 
*/

public class KSmallestUsingMinHeap{

	public static void main(String[] args){

		int[] arr=new int[]{11,2,13,4,500};
		int k=3;
		
		PriorityQueue<Integer> minHeapPq = new PriorityQueue<>(arr.length,new Comparator<Integer>(){

			public int compare(Integer o1,Integer o2){
				return o1-o2;
			}
		});
		



		for(int i=0;i<arr.length;i++){

			if(minHeapPq.size()<=(k-1)){
					minHeapPq.add(arr[i]);
			}
			else if(arr[i]<minHeapPq.peek()){

				minHeapPq.poll();
				minHeapPq.add(arr[i]);

			}
		}
		int count=0;
		while(!minHeapPq.isEmpty()){

			System.out.println((++count)+"st element smallest is  "+minHeapPq.remove());	

		}
		
	
		

	}


}
