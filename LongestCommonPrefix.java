public class Solution {
  public String longestCommonPrefix(String[] strs) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int l=0;
    if(strs.length<1) return "";
    StringBuffer r = new StringBuffer();
L:while(true) {
    char c = '\0';
    boolean flag=false;
    for(int i=0;i<strs.length;i++) {
      if(strs[i].length()<=l) break L;
      if(!flag){c=strs[i].charAt(l);flag=true;}
      else {
        if(c!=strs[i].charAt(l)) {
          break L;
        }
      }
    }
    r.append(c);
    l++;
  }
  return r.toString();

  }
  public String longestCommonPrefix(String[] strs) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int p=0;
    int n  = strs.length;
    if(n==0) return "";
    int minlen=strs[0].length();
    for(int i=0;i<n;i++) 
      if(minlen>strs[i].length()) minlen=strs[i].length();
    while(p<minlen) {
      char c = strs[0].charAt(p);
      for(int i=1;i<n;i++) 
        if(strs[i].charAt(p)!=c) return strs[0].substring(0,p); 
      ++p;
    }
    return strs[0].substring(0,p);

  }
}
