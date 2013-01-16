import java.io.*;
import java.util.*;

public class JumpGame {

  int canjump (int [] A) {
    int i=0,max=0,jumpcnt=0;
    while(i<A.length){
      jumpcnt++;
      if(max<(i+A[i])) max=i+A[i];
      if(max==i) return -1;
      if(max>=A.length-1) return jumpcnt;
      i=max;
    }
    return -1;

  }

  public static void main(String[] args) {
    //int[] a = new int[]{2,3,1,1,4};
    //int[] a = new int[]{3,2,1,0,4};
    int[] a = new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
    int r = new JumpGame().canjump(a);
    System.out.println(r);
  }

}
