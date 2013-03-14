import java.io.*;
import java.util.*;

public class Infix2Postfix {
  HashMap<String, Integer> mapPrece = new HashMap<String, Integer>();
  public List<String> toPostfix(String[] in) {
    mapPrece.put("*",2);
    mapPrece.put("/",2);
    mapPrece.put("+",1);
    mapPrece.put("-",1);
    List<String> pf = new ArrayList<String>();  
    Stack<String> stack = new Stack<String>();
    for ( String s : in ) {
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
    for(String s:pf)
      System.out.println(s);
    System.out.println();

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
    String[] tokens = str.split("(?<=[-+*/()])|(?=[-+*/()])");
    List<String> ls = new Infix2Postfix().toPostfix(tokens);
    for(String s:ls) {
      System.out.println(s);
    }
  }
}
