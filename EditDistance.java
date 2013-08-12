public class Solution {
    int min3(int x, int y, int z) {
        int min = x<y?x:y;
        int min1 = min<z?min:z;
        return min1;
    }
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        /*
            x,y start from 1. 1 means 1st char 
        */
        int l1 = word1.length(), l2 = word2.length();
        int[][] dist = new int[l1+1][l2+1]; 
   
        for(int i=1;i<=l2;i++) dist[0][i]=i;
        for(int i=1;i<=l1;i++) dist[i][0]=i;
        
        for(int i=1;i<=l1;i++) {
            for(int j=1;j<=l2;j++) {
                int diff=word1.charAt(i-1)==word2.charAt(j-1)?0:1;
                int d1 = dist[i-1][j-1]+diff;
                int d2 = dist[i-1][j]+1;
                int d3 = dist[i][j-1]+1;
                dist[i][j]=min3(d1,d2,d3);
            }
        }
        return dist[l1][l2];
        
    }
}
