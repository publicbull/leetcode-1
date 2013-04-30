public class Solution {
    void foo(int n1,int n2, ArrayList<String> r, StringBuffer buf) {
        if(n1==0&&n2==0) {
            r.add(buf.toString());
            return;
        }
        if(n1>0) {
            buf.append('(');
            foo(n1-1,n2,r,buf);
            buf.deleteCharAt(buf.length()-1);
        }
        if(n2>n1){
            buf.append(')');
            foo(n1,n2-1,r,buf);
            buf.deleteCharAt(buf.length()-1);
        }
    }
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> r = new ArrayList<String>();
        StringBuffer buf = new StringBuffer();
        foo(n,n,r,buf);
        return r;
        
    }
}
