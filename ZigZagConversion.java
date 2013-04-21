public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(nRows==1) return s;
        StringBuffer[] sbs = new StringBuffer[nRows];
        int idx=0,dir=1;
        for(int i=0;i<nRows;i++) {
            sbs[i] = new StringBuffer();
        }
        for(int i=0;i<s.length();i++) {
            sbs[idx].append(s.charAt(i));
            idx+=dir;
            if(idx==nRows) {
                dir=-1;
                idx=nRows-2;
            } else if(idx==-1) {
                dir=1;
                idx=1;
            }
        }
        StringBuffer r = new StringBuffer();
        for(int i=0;i<nRows;i++) {
            r.append(sbs[i].toString());
        }
        return r.toString();
    }
}
