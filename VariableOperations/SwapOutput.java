/*
Swapping the two numbers . Point to learn here is that java is pass by value here , hence output here in the main method stays 5,7
not 7,5
*/

public class SwapOutput {
   public static void main(String[] args) {
      int a = 5;
      int b = 7;
      swap(a,b);
      System.out.println(a + ", " + b);
   }
   public static void swap(int a, int b) {
      int temp = a;
      a = b;
      b = temp;
   }
}
