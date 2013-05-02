public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices.length<=1) return 0;
        
        int min=prices[0],max=0;
        for(int i=1;i<prices.length;i++) {
            if(min>prices[i]) min=prices[i];
            if(max<(prices[i]-min)) max=prices[i]-min;
        }
        return max;
        
    }
}
