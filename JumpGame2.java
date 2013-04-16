public class Solution {
  /* dp version. n^2. can't finish large test cases */
  public int jump_dp(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    //dp[i]=1+min{dp[i-a[j]]}
    int n = A.length;
    int[] dp = new int[n];
    for(int i=1;i<n;i++)dp[i]=-1;
    for(int i=1;i<n;i++) {
      int min=10000;
      for(int j=i-1;j>=0;j--) {
        if(dp[j]>=0&&(A[j]+j)>=i&&min>dp[j]){min=dp[j];}
      }
      if(min==10000){}
      else dp[i]=min+1;
    }

    return dp[n-1];

  }
  public int jump2(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int n = A.length;
    int i=0,cnt=0;
    while(i<n) {
      int max=0,maxj=0; 
      if(i>=n-1) return cnt;
      cnt++; 
      for(int j=1;j<=A[i];j++) {
        if((i+j)>=n-1) return cnt;
        if(max<(j+A[i+j])) {
          max=j+A[i+j];
          maxj=j;
        }
      }
      if(maxj==0) return 0;
      i+=maxj;
    }
    return cnt;

  }
}
