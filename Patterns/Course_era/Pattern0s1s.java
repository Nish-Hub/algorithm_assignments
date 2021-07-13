/*
Print the pattern 
0,0
0,1
1,0
1,1
2,0
2,1
*/


public class Pattern0s1s {
  public static void main(String [] args) {
    for( int x = 0; x<3; x++) {
      // XXX FOR LOOP MISSING // 
        for(int y = 0; y < 2; y++) {
        System.out.println(x + ", "+y);
      }
    }
  }
}
