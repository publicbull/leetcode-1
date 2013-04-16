public class Solution {
  int diff(String word1, String word2, int i, int j){
    if(word1.charAt(i)==word2.charAt(j)) return 0;
    else return 1;
  }

  int min3( int a,  int b,  int c){
    int m = a;
    if (m > b) m = b;
    if (m > c) m = c;
    return m;
  }
  public int minDistance(String word1, String word2) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int m = word1.length(), n=word2.length();
    int[][] dp = new int[m+1][n+1];
    for(int i=0;i<=n;i++) 
      dp[0][i]=i;
    for(int i=1;i<=m;i++) 
      dp[i][0]=i;
    for(int i=1;i<=m;i++) 
      for(int j=1;j<=n;j++) 
        dp[i][j]=min3(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+diff(word1,word2,i-1,j-1));
    return dp[m][n]; 
  }
}
