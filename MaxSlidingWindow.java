import java.io.*;
import java.util.*;

public class MaxSlidingWindow {
  void foo(int[] a,int w) {
    Deque<Integer> q = new LinkedList<Integer>();
    for(int i=0;i<w;i++) {
      while(!q.isEmpty() && a[i]>=a[q.peekLast()]) q.removeLast();
      q.offerLast(i);
    }
    System.out.println(a[q.peekFirst()]);
    for(int i=w;i<a.length;i++) {
      while(!q.isEmpty() && a[i]>=a[q.peekLast()]) q.removeLast();
      while(!q.isEmpty() && q.peekFirst()<=i-w) q.removeFirst();
      q.offerLast(i);
      System.out.println(a[q.peekFirst()]);
    }
  }
  public static void main(String[] args) {
    int [] a = new int[]{1 , 3  ,-1  ,-3 ,5  ,3  ,6, 7 };
    new MaxSlidingWindow().foo(a, 3);
  }
}
