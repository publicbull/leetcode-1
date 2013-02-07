import java.io.*;
import java.util.*;

public class EvalExpression {
  void printtokens(ArrayList<String> t, int i) {
    for(String token:t) {
      System.out.print(token+" ");
    }
    System.out.println(". i="+i);
  }
  double eval(ArrayList<String> tokens,int i,boolean neg) {
    printtokens(tokens,i);
    if(i==tokens.size()-1) return Double.parseDouble(tokens.get(i));
    double r=1;
    if(tokens.get(i+1).equals("*")) {
      r=Double.parseDouble(tokens.get(i))*Double.parseDouble(tokens.get(i+2))*(neg?-1:1); 
      tokens.set(i,r+"");
      tokens.remove(i+1);
      tokens.remove(i+1);
      return eval(tokens,i,false);
    } else if(tokens.get(i+1).equals("/")) {
      r=Double.parseDouble(tokens.get(i))/Double.parseDouble(tokens.get(i+2))*(neg?-1:1); 
      tokens.set(i,r+"");
      tokens.remove(i+1);
      tokens.remove(i+1);
      return eval(tokens,i,false);
    } else if(tokens.get(i+1).equals("+")) {
      r=Double.parseDouble(tokens.get(i)); 
      return r+eval(tokens,i+2,false);
    } else if(tokens.get(i+1).equals("-")) {
      r=Double.parseDouble(tokens.get(i)); 
      return r+eval(tokens,i+2, true);
    } else return 1.0;
    
  }
  void foo(String s) {
    String[] tokens = s.split("(?<=[-+*/])|(?=[-+*/])");
    long result=1;
    ArrayList<String> al = new ArrayList<String>(Arrays.asList(tokens));
    System.out.println(eval(al,0,false));
  }
  public static void main(String[] args) {
    new EvalExpression().foo("1000-5*6/3*2+1");
  }
}
