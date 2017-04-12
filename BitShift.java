/******************************************************************************
 *Some functions for bit-wise operations to start learning Java
 ******************************************************************************/

public class BitShift{
  public static void main(String[] args){
    //Demonstrate the overwrite method
    int sample = 0b0111000;
    int toOverwrite = 0b01111110010110;
    System.out.println("The coder chose the following binary number: " + Integer.toBinaryString(sample));
//    System.out.println("That number shifted to the left 2 is: " + Integer.toBinaryString(sample<<2));
    System.out.println("The the number to be overwritten is: " + Integer.toBinaryString(toOverwrite));
    int solution = overwrite(toOverwrite, sample, 7, 2);
    System.out.println("After overwriting with the coder chosen number at position 7 throuth 2 we have : " + Integer.toBinaryString(solution));

    //Demonstrate the substring finder method
    substringOnesFinder(toOverwrite);
    substringOnesFinder(1592);

  }

  //public static String flipBitToWin(int num){
    /*
    The problem is to find which bit to switch to produce an int with a maximal substring of
    consecutive ones
    */

    //flip each bit

    //call substringOnesFinder on each (requires modifying substringOnesFinder to return data)

    //return the best one
//  }

  public static void substringOnesFinder(int num){
    int length =0;
    int index =0;
    int stop = Integer.toBinaryString(num).length();

    for (int i=0; i<stop; i++){
      int ctr=0;
      int idx=0;
      while ((num & (1<<i+idx)) !=0){ //condition is that the i+idx-th digit is not zero
        ctr++;
        idx++;
      }
      if (ctr>length){
        length=ctr;
        index=i;
      }
    }
    /*This algorithim walks from right to left, and at each point, counts how many
    * consecutive ones exist to the left of that point. If a new best is found, it is set.
    */

    System.out.println("The longest substring of ones is of length " + length +
    " ending at index " + index);
    System.out.println("See? " + Integer.toBinaryString(num));

  }

  public static int overwrite(int firstNum, int secondNum, int j, int i){
    //method to overwrite the bits of firstNum from j to i with secondNum and trailing zeros
    //(under assumption that secondNum fits between j and i inclusive)

    //step 1, clear bits i to j
    int mask = ~1|1;
    for (int k=0; k<j-i; k++){
      mask = mask ^ (1 << k+i);
    }
    //System.out.println("mask is: "+ Integer.toBinaryString(mask));
    int clearedFirst = mask & firstNum;
    //System.out.println("clearedFirst is: "+ Integer.toBinaryString(clearedFirst));

    //step 2, shift secondNum by i
    int shiftedSecond = secondNum << i;
    //System.out.println("shiftedSecond is: "+ Integer.toBinaryString(shiftedSecond));

    //step 3, overwrite
    int solution = clearedFirst | shiftedSecond ;
    //System.out.println("solution is: "+ Integer.toBinaryString(solution));
    return solution;
  }



}
