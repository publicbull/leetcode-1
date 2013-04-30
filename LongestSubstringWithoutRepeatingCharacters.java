public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int b=0,e=0,max=0,n=s.length(),i=0;
        int[] cnt = new int[26];
        while(i<n) {
            //check(b,i,s.charAt(i),cnt);
            char c = s.charAt(i);
            if(cnt[c-'a']>0) {
                while(b<=i) {
                    if(cnt[c-'a']==0)break;
                    char c1=s.charAt(b);
                    cnt[c1-'a']--;
                    b++;
                }
            } 
            cnt[c-'a']=1;
            e=i;
            if(max<(e-b+1)) max=e-b+1;
            i++;
        }
        return max;
        
    }
}
