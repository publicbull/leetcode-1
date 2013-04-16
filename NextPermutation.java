import java.io.*;
import java.util.*;


class NextPermutation {

  void printArray(int[] num) {
    for(int a:num)
      System.out.print(a+" ");
    System.out.println();
  }
  void swap(int[] num, int i, int j) {
    int t=num[i];
    num[i]=num[j];
    num[j]=t;
  }
  void reverse(int[] num, int j, int ii) {
    while(j<ii) {
      swap(num,j,ii);
      ++j;--ii;
    }
  }
  public void nextPermutation(int[] num) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if(num.length<=1) return ;
    int n =num.length;
    int i=n-1,ii=i--;
    while(ii>=0) {
      i=ii-1;
      if(i>=0&&num[i]<num[ii])break;
      --ii;
    }
    if(i<0) {reverse(num,0,n-1);return;};
    int j=n-1;
    while(j>=ii) {
      if(num[i]>=num[j])--j;
      else break;
    }
    swap(num,i,j);
    reverse(num,ii,n-1);

  }
  public static void main(String[] args) {
    //int[] num = new int[]{1,2,3,4};
    int[] num = new int[]{0,0,0,1,9};
    NextPermutation foo = new NextPermutation();
    for(int i=0;i<100;i++) {
      foo.printArray(num);
      foo.nextPermutation(num);
      //foo.printArray(num);
      //System.out.println();
    }
  }

}

