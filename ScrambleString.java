import java.io.*;
import java.util.*;

public class ScrambleString {
  static String reverse(String s) {
    return new StringBuffer(s).reverse().toString();
  }

  public boolean isScramble(String s1, String s2) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int m=s1.length(),n=s2.length();
    if(m!=n) return false;

    boolean[][][] dp= new boolean[n][n][n+1];
    for(int i=n-1;i>=0;i--) {
      for(int j=n-1;j>=0;j--) {
        int maxij=Math.max(i,j);
        for(int k=1;k<=n-maxij;k++) {
          if(s1.substring(i,i+k).equals(s2.substring(j,j+k))) {
            dp[i][j][k]=true;
          } else {
            for(int t=1;t<k;t++) {
              if(dp[i][j][t]&&dp[i+t][j+t][k-t]||dp[i][j+k-t][t]&&dp[i+t][j][k-t]) {
                dp[i][j][k]=true;
                break;
              }
            }
          }
        }
      }
    }
    return dp[0][0][n];

  }

  /*
     too slow!
   */
  public boolean isScrambleRecursive(String s1, String s2) {
    // Start typing your Java solution below
    // DO NOT write main() function
    return foo(s1,s2)|foo(s1, reverse(s2));

  }

  boolean foo(String s1, String s2) {
    int l1=s1.length();
    int l2=s2.length();
    if(l1!=l2) return false;
    if(x.contains(s1+"-"+s2)) return true;
    if(x.contains(s2+"-"+s1)) return true;
    if(x.contains(s1+"-"+reverse(s2))) return true;
    if(x.contains(s2+"-"+reverse(s1))) return true;
    if(s1.equals(s2)) {x.add(s1+"-"+s2);return true;}
    if(s1.equals(reverse(s2))) {x.add(s1+"-"+s2);return true;}
    for(int i=1;i<l1;i++) {
      String s11=s1.substring(0,i);
      String s12=s1.substring(i);
      String s21=s2.substring(0,i);
      String s22=s2.substring(i);
      if(foo(s11, s21) && foo(s12, s22)) {x.add(s1+"-"+s2); return true;}
      if(foo(s11, reverse(s21)) && foo(s12, s22)) {x.add(s1+"-"+s2);return true;}
      if(foo(s11, reverse(s21)) && foo(s12, reverse(s22))) {x.add(s1+"-"+s2);return true;}

    }
    return false;
  }

  static HashSet<String> x = new HashSet<String>();

  public static void main(String[] a) {
    String s1="abcdefghij";
    String s2="efghijcadb";
    //s1="rgtae";
    //s2="great";
    boolean r = new IsScramble().isScramble(s1,s2);
    System.out.println(r);
    for(String k:x) {
      System.out.println(k);
    }
  }
}

