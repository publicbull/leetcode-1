#include<stdio.h>
#include<stdlib.h>

int ways(int a[], int n, int sum)
{
  int dp[sum+1];
  int i,x;
  dp[0] = 1;

  for(i = 1; i <= sum; i++)
    dp[i] = 0;

  for(i = 0; i < n; i++)
    for(x = 1; x <= sum; x++)
      if(x-a[i]>=0)
        //dp[x] = dp[x - a[i]] + dp[x];
        dp[x] += dp[x - a[i]];

  for(x = 0; x <= sum; x++)
    printf("dp[%d]:%d\n", x,dp[x]);
  return dp[sum];
}

int main() {
  int sum=5;
  int a[]={1,2};
  int n=2;
  int w = ways(a,n,sum);
  printf("%d\n", w);
  return 1;
}
