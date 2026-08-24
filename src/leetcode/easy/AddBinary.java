package leetcode.easy;

import java.math.BigInteger;

/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

 */
public class AddBinary {

  static void main() {

    String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
    String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

    String a1 = "11";
    String b1 = "1";

    System.out.println( addBinary( a, b ) );
    System.out.println();

    System.out.println( addBinary( a1, b1 ) );
    System.out.println();

    System.out.println( addBinaryWithBuiltIn( a1, b1 ) );
    System.out.println();

    System.out.println( addBinaryWithBigInt( a, b ) );
    System.out.println();

    System.out.println( addBinaryWithBigIntReturnString( a, b ) );
  }

  public static String addBinary( String a, String b ) {

    StringBuilder sb = new StringBuilder();

    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;

    while ( i >= 0 || j >= 0 || carry > 0 ) {
      int sum = carry;

      if ( i >= 0 ) {
        sum += a.charAt( i ) - '0'; // necessary to convert to int
        i--;
      }
      if ( j >= 0 ) {
        sum += b.charAt( j ) - '0';
        j--;
      }

      sb.append( sum % 2 ); // append sum divided by 2

      carry = sum / 2; // if sum is 2 or greater there will be a carry
    }

    return sb.reverse()
             .toString(); // we added to the string from right to left so we have to reverse
  }

  /*
   As the long data type will only hold 64 bit numbers, the convenience methods of Long.parseLong
   (String, Radix) and Long.toBinaryString(String) or similar will break under Strings larger than
   63 characters.

   For certain cases, this makes using the BigInteger class or iterating over each
   character necessary to avoid runtime exceptions.
   */
  public static String addBinaryWithBuiltIn( String a, String b ) {

    int intA = Integer.parseInt( a, 2 );
    int intB = Integer.parseInt( b, 2 );

    int sum = intA + intB;
    String result = Integer.toBinaryString( sum );

    return result;
  }

  public static BigInteger addBinaryWithBigInt( String a, String b ) {

    BigInteger bigA = new BigInteger( a, 2 );
    BigInteger bigB = new BigInteger( b, 2 );

    return bigA.add( bigB );
  }

  public static String addBinaryWithBigIntReturnString( String a, String b ) {

    BigInteger bigA = new BigInteger( a, 2 );
    BigInteger bigB = new BigInteger( b, 2 );

    return bigA.add( bigB )
               .toString( 2 );
  }
}
