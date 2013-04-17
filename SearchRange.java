public class SearchRange {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l=0,r=A.length-1,m=0;
        boolean found=false;
        while(l<=r) {
            System.out.println(l+" "+r);
            m = (l+r)/2;
            if(A[m]==target) {
                found=true;
                break;
            } else if(A[m]<target) {
                l=m+1;
            } else {
                r=m-1;
            }
        }
        if(found) {
            l=m-1;
            while(l>=0&&A[l]==target) {
                l--;
            }
            r=m+1;
            while(r<A.length&&A[r]==target) {
                r++;
            }
            return new int[]{l+1,r-1};
        } else 
            return new int[]{-1,-1};
        
    }
    public static void main(String[] args) {
      int[] a = new int[]{2,2};
      new SearchRange().searchRange(a,3);
    }
}
