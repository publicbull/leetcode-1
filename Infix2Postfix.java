import java.io.*;
import java.util.*;

public class Infix2Postfix {
  HashMap<String, Integer> mapPrece = new HashMap<String, Integer>();
  public Infix2Postfix() {
    mapPrece.put("*",2);
    mapPrece.put("/",2);
    mapPrece.put("+",1);
    mapPrece.put("-",1);
  }
  public List<String> toPostfix(String[] in) {
    List<String> pf = new ArrayList<String>();  
    Stack<String> stack = new Stack<String>();
    ArrayList<String> subExpr = new ArrayList<String>(); 
    boolean inSubExpr=false;
    for ( String s : in ) {
      if(s.equals("(")) {
        subExpr.clear();
        inSubExpr=true; 
        continue;
      }
      if(s.equals(")")) {
        String[] _subExpr = new String[subExpr.size()];
        for(int i=0;i<subExpr.size();++i) {
          _subExpr[i]=subExpr.get(i);
        }
        for(String s1:toPostfix(_subExpr))
          pf.add(s1);
        inSubExpr=false; 
        continue;
      }
      if(inSubExpr) {
        subExpr.add(s);
        continue;
      }
      int p = getPrecedence( s );
      if ( p == 0 ) 
        pf.add( s );
      else if ( stack.empty() )
        stack.push( s );
      else {
        while( !stack.isEmpty() && getPrecedence( stack.peek() ) >= p )
          pf.add( stack.pop() );
        stack.push( s );
      }
    }
    while( !stack.isEmpty() )
      pf.add( stack.pop() ); 

    return pf;
  }

  private int getPrecedence(String s) {
    if(mapPrece.containsKey(s)) return mapPrece.get(s);
    else return 0;
  }
  public static void main(String[] args) {
    String str="1000-5*6/3*2+1";
    str="1*(2+3)+4";
    str="1.5+2+3.4*(25-4)/2-8";
    String[] tokens = str.split("(?<=[-+*/()])|(?=[-+*/()])");
    List<String> ls = new Infix2Postfix().toPostfix(tokens);
    for(String s:ls) {
      System.out.println(s);
    }
  }
}
