public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if(prices.length<=1) return 0;
        
        int n = prices.length;
        int[] maxfw = new int[n];

        int min=prices[0],max=0;
        for(int i=1;i<n;i++) {
            if(min>prices[i]) min=prices[i];
            if(max<(prices[i]-min)) max=prices[i]-min;
            maxfw[i]=max;
        }
        max=0;
        int maxbk=0,maxsum=0;
        for(int i=n-1;i>0;i--) {
            if(maxbk<prices[i]) maxbk=prices[i];
            if(max<(maxbk-prices[i])) max=maxbk-prices[i];
            if(maxsum<(maxfw[i]+max)) maxsum=maxfw[i]+max;
        }
        return maxsum;
        
    }
}
