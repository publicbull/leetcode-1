public class Solution {
    void swap(int[] A,int i, int j) {
        int t=A[i];
        A[i]=A[j];
        A[j]=t;
    }
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=0,s=0;
        while(i<A.length) {
            if(A[i]!=elem) {
                swap(A,i,s);
                ++s;
            }
            ++i;
        }
        return s;
        
    }
}
