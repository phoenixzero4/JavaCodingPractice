package leetcode.easy;

public class AddDigits {

  /*
  Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
   */

  static void main() {

    int num = 38;
    int result = addDigits( num );
    System.out.printf( "Sum of digits in %d is %d", num, result );
  }

  public static int addDigits( int num ) {

    int sum = 0;

    while ( num > 0 ) {

      sum += num % 10;
      num /= 10;

      if ( sum < 10 && num <= 0 ) {
        return sum;
      }
      else if ( num <= 0 && sum > 9 ) {
        num = sum;
        sum = 0;
      }
    }
    return sum;
  }
}
