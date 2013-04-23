public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<String> stack  = new Stack<String>();
        String[] dirs = path.split("/");
        for(int i=0;i<dirs.length;i++) {
            if(dirs[i].equals(".")||dirs[i].equals("")) {
                
            } else if (dirs[i].equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(dirs[i]);
            }
        }
        StringBuffer buf = new StringBuffer();
        List<String> list = new ArrayList<String>(stack);
        for(int i=0;i<list.size();i++) {
            buf.append("/"+list.get(i));
        }
        if(buf.length()>0) return buf.toString();
        else return "/";
    }
}
