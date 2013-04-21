public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lh=haystack.length();
        int ln=needle.length();
        if(lh<ln) return null;
        for(int i=0;i<=lh-ln;i++) {
            int j;
            for(j=0;j<ln;j++) {
                if(haystack.charAt(i+j)!=needle.charAt(j)) break;
            }
            if(j==ln) return haystack.substring(i);
        }
        return null;
    }
}
