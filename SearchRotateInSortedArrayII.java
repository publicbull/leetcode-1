public class Solution {
    boolean search(int[] A, int l, int r, int target) {
        int m=0;
        while(l<=r) {
            m=l+(r-l)/2;
            if(target==A[m]) return true;
            if(A[l]<A[m]) {//this is critical
                if(target>=A[l] && target<=A[m]) r=m-1;
                else l=m+1;
            } else if(A[l]>A[m]) {
                if(target>=A[m]&&target<=A[r])
                    l=m+1;
                else r=m-1;
            } else {
                if(!search(A,l,m-1,target)) {
                    if(search(A,m+1,r,target)) {
                        return true;
                    } else return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return search(A,0,A.length-1,target); 
    }
}
