public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = obstacleGrid.length;
        if(m==0) return 0;
        int n = obstacleGrid[0].length;
        
        int[][] L = new int[m][n];
        if(m==0||n==0) return 1;

        for(int i=0;i<m;i++) {
            if(obstacleGrid[i][0]==1) break;
          L[i][0]=1;
        }
        for(int i=0;i<n;i++) {
            if(obstacleGrid[0][i]==1) break;
          L[0][i]=1;
        }
        for(int i=1;i<m;i++) {
          for(int j=1;j<n;j++) {
              if(obstacleGrid[i][j]==1) continue;
            L[i][j]=L[i-1][j]+L[i][j-1];
          }
        }
        return L[m-1][n-1]; 
        
    }
}
