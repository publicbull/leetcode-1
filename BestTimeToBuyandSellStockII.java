public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices.length==0) return 0;

        int sum=0;
        for(int i=1;i<prices.length;i++) {
            int diff = prices[i]-prices[i-1];
            if(diff>0) sum+=diff;
        }
        return sum;
        
    }
}
