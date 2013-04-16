public class Solution {
    void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i]=A[j];
        A[j]=t;
    }
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //R W B
        int n = A.length;
        int r=0,w=0,b=n-1;
        while(w<=b) {
            if(A[w]==0) {
                swap(A,w++,r++);
            } else if(A[w]==2) {
                swap(A,w,b--);
            } else {
                w++;
            }
        }
        
    }
}
