public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=-1;
        int l=0,r=A.length-1;
        while(l<=r) {
            m = l+(r-l)/2;
            if(A[m]==target) {
                return m;
            }
            else if(A[m]<target) l=m+1;
            else r=m-1;
        }
        if(A[m] < target)
            return m+1;
        else
            return m;
    }
}
