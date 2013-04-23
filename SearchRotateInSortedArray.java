public class SearchRotate {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int L=0,R=A.length-1,M=0;
        while(L<=R) {
            M=L+(R-L)/2;
            if(target==A[M]) return M;
            if(A[L]<=A[M]) {//this is critical
                if(target>=A[L] && target<=A[M]) R=M-1;
                else L=M+1;
            } else {
                if(target>=A[M]&&target<=A[R])
                    L=M+1;
                else R=M-1;
            }
        }
        return -1;
    }
  public static void main(String[] args) {
    //int[] A=new int[]{4,5,6,7,0,1,2};
    //int[] A=new int[]{3,5,1};
    int[] A=new int[]{3,1};
    int r=new SearchRotate().search(A, 3);
    System.out.println(r);
  }
    
}

