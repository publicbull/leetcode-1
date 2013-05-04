public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = s.length();
        if(n==0) return 0;
        int[] dp = new int[n];
        boolean[] valid = new boolean[n];
        if(s.charAt(0)=='0') {
            dp[0]=0;
            valid[0]=false;
        }
        else {
            dp[0]=1;
            valid[0]=true;
        }
        for(int i=1;i<n;i++) {
            char c = s.charAt(i);
            char c1 = s.charAt(i-1);
            if(c=='0') {//00-90 (10,20 are valid)
                if(c1=='1'||c1=='2') {
                    if(i<2) {
                        valid[i]=true;
                        dp[i]=1;
                    } else {
                        if(valid[i-2]) {
                            valid[i]=true;
                            dp[i]=dp[i-2];
                        } else {
                            valid[i]=false;
                            dp[i]=0;
                        }
                    }
                } else {
                    valid[i]=false;
                    dp[i]=0;
                }
            } else if (c1=='1') {//11 - 19
                if(i<2) {
                    valid[i]=true;
                    dp[i]=2;
                } else if(valid[i-2]) {
                    valid[i]=true;
                    dp[i]=dp[i-1]+dp[i-2];
                } else {
                    valid[i]=false;
                    dp[i]=0;
                }
            } else if(c1=='2') {
                if(c>='1'&&c<='6') {
                    if(i<2) {
                        valid[i]=true;
                        dp[i]=2;
                    } else if(valid[i-2]) {
                        valid[i]=true;
                        dp[i]=dp[i-1]+dp[i-2];
                    } else {
                        valid[i]=false;
                        dp[i]=0;
                    }                    
                } else {//27,28,29
                    if(i<2) {
                        valid[i]=true;
                        dp[i]=1;
                    } else if(valid[i-1]) {
                        valid[i]=true;
                        dp[i]=dp[i-1];
                    }
                    else {
                        valid[i]=false;
                        dp[i]=0;
                    }          
                }
            } else {//3x,4x,...
                valid[i]=valid[i-1];
                dp[i]=dp[i-1];
            }    
        }
        if(valid[n-1])
            return dp[n-1];
        else
            return 0;
        
    }
}

