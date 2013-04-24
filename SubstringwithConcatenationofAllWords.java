import java.io.*;
import java.util.*;

public class SubstringwithConcatenationofAllWords {
  //recursion. too slow
  void match2(String s, String[] L,boolean[] used, int step,int start,ArrayList<Integer> r, int cntUnused, int lstart) {
    if(cntUnused==0) {
      r.add(start);return;
    }
    int restcnt=step*cntUnused;
    for(int i=0;i<=s.length()-restcnt;i+=step) {
      String word=s.substring(0,step);
      for(int j=0;j<L.length;j++) {
        if(!used[j]&&word.equals(L[j])) {
          used[j]=true;
          cntUnused--;
          match2(s.substring(step),L,used,step,start,r,cntUnused,lstart+1);
          if(cntUnused==0) return;
          used[j]=false;
          cntUnused++;
        }
      }
    }
  }
  public ArrayList<Integer> findSubstring(String S, String[] L) {
    ArrayList<Integer> r = new ArrayList<Integer>();
    HashMap<String, Integer> x = new HashMap<String, Integer>();
    for(String s:L) {
      if(!x.containsKey(s)) 
        x.put(s,1);
      else
        x.put(s,x.get(s)+1); 
    }
    int step = L[0].length();
    int substrlen = L.length*step;
    for(int i=0;i<=S.length()-substrlen;i++) {
      Map<String, Integer> x1 = new HashMap<String, Integer>(x);
      int j;
      for(j=0;j<L.length;j++) {
        String word=S.substring(i+j*step,i+(j+1)*step);
        if(x1.containsKey(word)) 
          if(x1.get(word)==1)
            x1.remove(word);
          else
            x1.put(word,x1.get(word)-1);
        else
          break;
      } 
      if(j==L.length) 
        r.add(i);
    } 
    return r;
  }
  public ArrayList<Integer> findSubstring2(String S, String[] L) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<Integer> r = new ArrayList<Integer>();
    int step = L[0].length();
    int substrlen = L.length*step;
    for(int i=0;i<=S.length()-substrlen;i++) {
      //boolean[] used = new boolean[L.length];
      //match(S.substring(i),L,used,step,i,r, L.length,0);
    }
    return r;
  }
  public static void main(String[] args) {
    String[] L = new String[]{"bcb","baa","cac","aca","cca"};
    ArrayList<Integer> r = new SubstringwithConcatenationofAllWords().findSubstring("abcbaaaccaabbcababaaabccaabccccbbccbaabcbccacacacabcbbbacbcbbccabaccbbbcbaabbabbaaaacaacbcacbbaacbcbcbabbbcacbbacaacbbbcacccbbcacabbbacaccbcbaababa",L);
    for(int i:r) {
      System.out.println(i);
    }
  }
}
