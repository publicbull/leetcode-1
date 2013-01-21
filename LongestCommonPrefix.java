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
}
