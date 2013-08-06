public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] cnt = new int[26];
        int max=0,b=0,e=0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            int idx=c-'a';
            while(cnt[idx]>0) {
                cnt[s.charAt(b)-'a']--;
                b++;
            }
            e=i;
            cnt[idx]++;
            if(max<(e-b+1)) max=e-b+1;
        }
        return max;
        
    }
}
