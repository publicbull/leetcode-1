public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len=0,i;
        int n = s.length();
        for(i=n-1;i>=0;i--) {
            if(s.charAt(i)!=' ') break;
        }
        for(;i>=0;i--) {
            if(s.charAt(i)==' ') break;
            len++;
        }
        return len;
    }
}
