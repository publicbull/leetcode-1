import java.io.*;
import java.util.*;

public class FindUniqueElementInArray {
  class NumberFlags
  {
    // 25000 bits => 3125 bytes
    private byte[] byteFlags = new byte[3126];
    public void Put(int number)
    {
      int byteIndex = number / 8;
      int bitIndex = number % 8;
      byteFlags[byteIndex] = (byte)(byteFlags[byteIndex] | (1 << bitIndex)
          );
    }

    public void Remove(int number)
    {
      int byteIndex = number / 8;
      int bitIndex = number % 8;
      byteFlags[byteIndex] = (byte)(byteFlags[byteIndex] & ~(1 << bitIndex
            ));
    }

    public boolean Exists(int number)
    {
      int byteIndex = number / 8;
      int bitIndex = number % 8;
      int value = byteFlags[byteIndex] & (1 << bitIndex);
      return value > 0;
    }
    public void print() {
      for(int i=0;i<3126;i++) {
        System.out.print(byteFlags[i]+" ");
      }
      System.out.println();
    }
  }

  NumberFlags findUnique(int [] array)
  {
    NumberFlags numberFlags = new NumberFlags();
    for (int i = 0; i < array.length; i++)
    {
      if (numberFlags.Exists(array[i]))
        array[i] = -array[i];
      else
        numberFlags.Put(array[i]);
    }

    for (int i = 0; i < array.length; i++)
    {
      if (array[i] < 0)
      {
        array[i] = -array[i];
        numberFlags.Remove(array[i]);
      }
    }

    return numberFlags;
  }
  void test() {
    Random r = new Random();
    int N=100;
    int max=100,min=1;
    int[] nums = new int[N];
    for(int i=0;i<N;i++) {
      nums[i]=min+(int)(Math.random()*(max-min+1));
    }
    Arrays.sort(nums);
    for(int i=0;i<N;i++) {
      System.out.print(nums[i]+" ");
    }
    System.out.println();
    NumberFlags nf = findUnique(nums);
    for(int i=0;i<N;i++) {
      if(nf.Exists(nums[i])) System.out.print(nums[i]+" ");
    }
    System.out.println();
  }
  public static void main(String[] args) {
    FindUniqueElementInArray foo =new FindUniqueElementInArray();
    foo.test();
  }
}
