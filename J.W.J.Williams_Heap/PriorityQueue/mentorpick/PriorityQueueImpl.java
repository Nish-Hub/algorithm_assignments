// Prob : https://mentorpick.com/blog/view/5b9b8dddc0f04370636ce163
import java.util.*;

public class PriorityQueueImpl{

  public static void main(String[] args){
  
    int initialCapacity=100;
    
    // Constructing a min heap using a priority queue with a comparator which arranges the elements in increasing order
    
    PriorityQueue<Integer> minHeapPq = new PriorityQueue<Integer>(initialCapacity,new Comparator<Integer>(){
      
      public int compare(Integer o1,Integer o2){
        return o1-o2 ;
      }
    }
    
    // Constructing a max heap using a priority queue with a comparator which arranges the elements in increasing order
    
    PriorityQueue<Integer> maxHeapPq = new PriorityQueue<Integer>(initialCapacity,new Comparator<Integer>(){
      
      public int compare(Integer o1,Integer o2){
        return o2-o1 ;
      }
    }
  
  // Adding elements to pq 
  minHeapPq.add(10);
  minHeapPq.add(12);
  
  Iterator minIterator=minHeapPq.iterator();
  while(minIterator.hasNext()){
    
    System.out.println("Element popped is "+minIterator.next());
  
  }

  while(!minHeapPq.isEmpty()){
    int minElement = minHeapPq.pop();
    System.out.println("Element popped is "+minElement);
    System.out.println("Size of Min heap pq is  "+minHeapPq.size());
  
  }
}
