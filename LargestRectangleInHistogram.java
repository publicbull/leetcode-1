import java.io.*;
import java.util.*;

public class LargestRectangleInHistogram {
  int stack(int[] h) {
    Stack<Integer> s = new Stack<Integer>();
    int m=0,i=0;
    while(i<h.length) {
      if(s.empty()||h[i]>=h[s.peek()]) {
        s.push(i++);
      } else {
        int t = s.pop();
        m=Math.max(m,h[t]*(s.empty()?i:i-s.peek()-1));
        //System.out.println("m="+m);
      }
    }
    while(!s.empty()) { 
      int t = s.pop();
      m=Math.max(m,h[t]*(s.empty()?i:i-s.peek()-1));
      //System.out.println("m="+m);
    }
    return m;
  }
  int recur(int[] h,int l, int r) {
    if(r<=l) return 0;
    int min=l;
    for(int i=l+1;i<r;i++) {
      if(h[i]<h[min]) min=i;
    }
    int m1=h[min]*(r-l);
    return Math.max(m1,Math.max(recur(h,l,min), recur(h,min+1,r)));
  }
  public static void main(String[] args) {
    //int[] h = new int[]{2,1,5,6,2,3};
    //int[] h = new int[]{3,6,5,7,4,8,1,0};
    int[] h = new int[]{4,3,4,5};
    //int[] h = new int[]{1};
    int s = new LargestRectangleInHistogram().recur(h,0,h.length);
    System.out.println(s);
    s = new LargestRectangleInHistogram().stack(h);
    System.out.println(s);
  }
}
