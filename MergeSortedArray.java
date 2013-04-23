public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int pa=m-1,pb=n-1,pc=m+n-1;
        while(pa>=0&&pb>=0) {
            if(A[pa]<B[pb]) 
                A[pc--]=B[pb--];
             else 
                A[pc--]=A[pa--];
        }
        while(pb>=0) 
            A[pc--]=B[pb--];
    }
}
