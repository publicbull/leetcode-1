public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int c=1,i;
        int l = digits.length;
        for(i=l-1;i>=0;i--) {
            int t = digits[i]+c;
            if(t<10) {digits[i]++;break;}
            else {
                c=1;
                digits[i]=t%10;
            }
        }
        if(i==-1&&c==1) {
            int[] r = new int[l+1];
            r[0]=1;
            for(i=1;i<=l;i++) r[i]=digits[i-1];
            return r;
        }else return digits;
        
    }
}
