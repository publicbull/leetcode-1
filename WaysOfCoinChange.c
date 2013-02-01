#include<stdio.h>
#include<stdlib.h>

/*
 http://www.algorithmist.com/index.php/Coin_Change
*/

/* 
recursive solution
sum N till item m
count(n,m) = count(n,m-1)+count(n-s[m],m)
*/
int ways_rc(int *a, int n, int sum) {
  printf("n=%d sum=%d\n", n, sum);
  if(sum==0) return 1;
  if(sum<0) return 0;
  if(n<=0 && sum>=1) return 0;
  return ways_rc(a, n-1,sum)+ways_rc(a,n,sum-a[n-1]);
}

int ways_dp1(int *a, int n, int sum) {
  int i,j;
  int dp[sum+1][n+1];

  //if sum==0, then always return 1
  for(j=0;j<=n;j++) {
    dp[0][j]=1;
  }
  //if sum>0,n==0 then always return 0
  for(i=1;i<=sum;i++) {
    dp[i][0]=0;
  }
  for(i=0;i<=sum;i++) {
    for(j=1;j<=n;j++) {
      int p=dp[i][j-1];
      int q=((i-a[j-1])<0)?0:dp[i-a[j-1]][j];
      dp[i][j]=p+q;
    }
  }
  return dp[sum][n];
}

//1-dimension dp
//
int ways_dp2(int *a, int n, int sum) {
  int i,j;
  int dp[sum+1];

  dp[0]=1;
  //if sum>0,n==0 then always return 0
  for(i=1;i<=sum;i++) {
    dp[i]=0;
  }
  for(j=1;j<=n;j++) {
    for(i=0;i<=sum;i++) {
      int p=dp[i];
      int q=((i-a[j-1])<0)?0:dp[i-a[j-1]];
      dp[i]=p+q;
    }
  }
  return dp[sum];
}

//copied from mit
int ways2(int a[], int n, int sum)
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
  //int w = ways_rc(a,n,sum);
  int w = ways_dp2(a,n,sum);
  printf("%d\n", w);
  return 1;
}
