public class Solution {
    boolean match(char c, Stack<Character> st, char c1, char c2) {
        if(c!=c2) return true;
        if(st.empty()) return false;
        if(st.peek()!=c1) return false;
        st.pop();
        return true;
    }
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{')
                st.push(c);
            else {
                if(!match(c,st,'(',')')) return false;
                if(!match(c,st,'[',']')) return false;
                if(!match(c,st,'{','}')) return false;
            }
        }
        if(st.empty())
            return true;
        else
            return false;
    }
}
