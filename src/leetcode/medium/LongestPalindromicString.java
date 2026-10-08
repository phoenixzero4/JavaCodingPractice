package leetcode.medium;

/* Leetcode # 5
Longest Palindromic Substring
Given a String s, return the longest palindromic substring in s
 */

public class LongestPalindromicString {

  // static List<String> palindromes;

  static void main( String[] args ) {

    String in = "abbcccba";
    System.out.println( longestPalindrome( in ) );

    in = "cbbd";
    System.out.println( longestPalindrome( in ) );

    in = "jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel";
    System.out.println( longestPalindrome( in ) );
    //    for ( String s : palindromes ) {
    //      System.out.println( s );
    //    }
  }

  public static String longestPalindrome( String s ) {

    //  palindromes = new ArrayList<>();

    String max = "";
    String sub;

    //    for ( int i = 0; i < s.length(); i++ ) {
    //
    //      sub = s.substring( i );
    //
    //      System.err.println( "Testing: " + sub );
    //
    //      if ( isPalindrome( sub ) ) {
    //        //  palindromes.add( sub );
    //
    //        if ( sub.length() > max.length() ) {
    //          max = sub;
    //        }
    //      }
    //    }

    //    for ( int j = s.length(); j >= 0; j-- ) {
    //      sub = s.substring( 0, j );
    //
    //      System.err.println( "Testing: " + sub );
    //
    //      if ( isPalindrome( sub ) ) {
    //        //  palindromes.add( sub );
    //
    //        if ( sub.length() > max.length() ) {
    //          max = sub;
    //        }
    //      }
    //    }

    for ( int i = 0; i <= s.length(); i++ ) {

      //      sub = s.substring( i );
      //      if ( isPalindrome( sub ) && sub.length() > max.length() ) {
      //        max = sub;
      //      }

      for ( int j = s.length(); j > i; j-- ) {
        sub = s.substring( i, j );
        if ( isPalindrome( sub ) && sub.length() > max.length() ) {
          max = sub;

        }
      }
    }
    return max;
  }

  public static boolean isPalindrome( String str ) {

    char[] array = str.toCharArray();

    for ( int i = 0, j = str.length() - 1; i <= j; i++, j-- ) {
      if ( array[i] != array[j] ) {
        return false;
      }

    }
    return true;
  }
}
