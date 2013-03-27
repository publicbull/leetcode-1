public class Solution {
    boolean isAlphaNum(char c) {
        if(c>='a' && c<='z') return true;
        else if(c>='0' && c<='9') return true;
        else return false;
    }
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=0,j=s.length()-1;
        String t = s.toLowerCase();
        while(i<j) {
            char c1= t.charAt(i);
            if(!isAlphaNum(c1)) {++i;continue;}
            char c2= t.charAt(j);
            if(!isAlphaNum(c2)) {--j;continue;}
            if(c1!=c2) return false;
            ++i;--j;
        }
        return true;
    }
}
