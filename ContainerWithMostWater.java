public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = height.length;
        int i=0,j=n-1,max=0;
        while(i<j) {
            int hi = height[i], hj=height[j];
            int sz = (j-i)*(hi<hj?hi:hj);
            if(max<sz)max=sz;
            if(hi<hj) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
