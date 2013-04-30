public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        if(m==0) return;
        int n = matrix[0].length;
        if(n==0) return;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for(int i=0;i<m;i++) {
            if(matrix[i][0]==0) {
                firstColZero = true;
                break;
            }
        }
        for(int i=0;i<n;i++) {
            if(matrix[0][i]==0) {
                firstRowZero = true;
                break;
            }
        }
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[i][j]==0) {
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[0][j]==0||matrix[i][0]==0) {
                    matrix[i][j]=0;
                }
            }
        }
        if(firstRowZero) {
            for(int i=0;i<n;i++) matrix[0][i]=0;
        }
        if(firstColZero) {
            for(int i=0;i<m;i++) matrix[i][0]=0;
        }
        
    }
}
