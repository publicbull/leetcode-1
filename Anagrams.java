import java.io.*;
import java.util.*;

public class Anagrams {
  void foo() {
    String s1="abcd";
    String s2="dabc";
    String s3="dabe";
    String[] strs = {"abc","cba","efg"};
    anagrams(strs);
  }
  public ArrayList<String> anagrams(String[] strs) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<String> r = new ArrayList<String>();
    //HashMap<char[], Integer> x = new HashMap<char[], Integer>();
    HashMap<char[], ArrayList<String>> x = new HashMap<char[], ArrayList<String>>();
    for(int i=0;i<strs.length;i++) {
      String s = strs[i];
      System.out.println(s);
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      System.out.println(chars);
      if(x.containsKey(chars)) {
        x.get(chars).add(s);
      } else {
        x.put(chars, new ArrayList<String>());
        x.get(chars).add(s);
      }
    }
    for(char[] key:x.keySet()) {
      ArrayList<String> arr = x.get(key);
          System.out.println("key:"+key+" "+arr.size());
      if(arr.size()>1) {
        for(String s:arr) {
          System.out.println(s);
        }
        System.out.println();
        r.addAll(arr);
      }
    }
    return r;

  }
  public static void main(String[] args) {
    new Anagrams().foo();
  }
}
