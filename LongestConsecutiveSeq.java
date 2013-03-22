import java.io.*;
import java.util.*;

public class LongestConsecutiveSeq {
  
  int foo(int[] a, HashSet<Integer> x) {
    for(int aa : a) {
      x.add(aa);
    }
    int max=0;
    while(!x.isEmpty()) {
      int pv = x.iterator().next();
      int p=pv;
      int len=0;
      while(x.contains(p)) {
        len++;
        x.remove(p);
        p++;
      }
      p=pv-1;
      while(x.contains(p)) {
        len++;
        x.remove(p);
        p--;
      }
      if(max<len)max=len;
       
    }
    return max;
  }
  public static void main(String[] args) {
    int[] a = new int[]{100, 4, 200, 1, 3, 2};
    HashSet<Integer> x = new HashSet<Integer>();
    new LongestConsecutiveSeq().foo(a,x);
  }
}
