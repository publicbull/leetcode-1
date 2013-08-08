public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs.length==0) return "";
        StringBuffer buf = new StringBuffer();
        int p=0;
        L:
        while(true) {
            char c=0;
            for(int i=0;i <strs.length;i++) {
                String s = strs[i];
                if(s.length()<=p) break L;
                if(c==0) c = s.charAt(p);
                else if(c!=s.charAt(p)) break L;
            }
            buf.append(c);
            p++;
        }
        return buf.toString();
        
    }
}
