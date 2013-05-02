import java.io.*;
import java.util.*;

public class MinimumWindowSubstring {
    int update_begin(int b, int e, int[] need, int[] cnt, String s) {
        while(b<=e) {
            char c = s.charAt(b);
            if(need[c]==0||cnt[c]>need[c]) {
                b++;
                cnt[c]--;
            } else 
                return b;
        }
        return b;
    }
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(S.length()<T.length()) return ""; 
        int i,b=0,m=T.length(),n=S.length(),minb=0,mini=0,min=Integer.MAX_VALUE,covered_cnt=0;
        int[] cnt = new int[256], need = new int[256];
        boolean covered=false;
        for(i=0;i<T.length();i++) 
            need[T.charAt(i)]++;
        i=0;
        for(i=0;i<n;i++) {
            char c = S.charAt(i);
            if(need[c]==0) continue;
            cnt[c]++;
            if(cnt[c]<=need[c]) covered_cnt++;
            if(covered_cnt>=m) {
                covered=true;
                b=update_begin(b,i,need,cnt,S);
                if(min>(i-b)){min=i-b;minb=b;mini=i;}
            }
        }
        if(covered) {
            return S.substring(minb,mini+1);
        } else 
            return ""; 
    }
  public static void main(String[] args) {
    String s = new MinimumWindowSubstring().minWindow("ADOBECODEBANC","ABC");
    System.out.println(s);
  }
}
