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

    void foo(int l, int r, char[] cs,int depth, ArrayList<String> result) {
        //l,r are available ( and )
        if(l==0&&r==0) {
            result.add(new String(cs));
            return;
        }
        if(l>0) {
                cs[depth]='(';
                foo(l-1,r,cs,depth+1,result);
        }
        if(l<r) {
            if(r>0) {
                cs[depth]=')';
                foo(l,r-1,cs,depth+1,result);
            }
        }
    }
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] cs = new char[2*n];
        ArrayList<String> r = new ArrayList<String>();
        foo(n,n,cs,0,r);
        return r;
    }
}
