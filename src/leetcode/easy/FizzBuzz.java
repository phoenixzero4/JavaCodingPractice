package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer n, return a string array where:
  answer[i] == "FizzBuzz" if i is divisible by 3 and 5
  answer[i] == "Fizz" if i is divisible by 3
  answer[i] == "Buzz" if i is divisible by 5
  answer[i] == "i" if none of the above are true
 */
public class FizzBuzz {

  static void main() {

    int n = 15;
    List<String> result = fizzBuzz( n );

    for ( int i = 0; i < result.size(); i++ ) {
      System.out.println( ( i + 1 ) + " = " + result.get( i ) );
    }
  }

  public static List<String> fizzBuzz( int n ) {

    List<String> list = new ArrayList<>();

    for ( int i = 1; i <= n; i++ ) {

      if ( i % 5 == 0 && i % 3 == 0 ) {
        list.add( "FizzBuzz" );
      }
      else if ( i % 3 == 0 ) {
        list.add( "Fizz" );
      }
      else if ( i % 5 == 0 ) {
        list.add( "Buzz" );
      }
      else {
        list.add( String.valueOf( i ) );
      }
    }
    return list;
  }
}
