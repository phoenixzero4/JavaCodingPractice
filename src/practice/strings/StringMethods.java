package practice.strings;

public class StringMethods {

  static void main( String[] args ) {

    String a = "abba";
    String b = "abbad";
    String racecar = "racecar";
    String panama = "panama";
    String plan = "A man, a plan, a canal,  Panama";

    System.out.println( a + " is a palindrome " + isPalindrome( a ) );
    System.out.println( b + " is a palindrome " + isPalindrome( b ) );
    System.out.println( racecar + " is a palindrome " + isPalindrome( racecar ) );
    System.out.println( panama + " is a palindrome " + isPalindrome( panama ) );
    System.out.println( plan + " is a palindrome " + isPalindrome( plan ) );

  }

  public static boolean isPalindrome( String s ) {

    s = s.replaceAll( "[^a-zA-Z]", "" );
    s = s.trim()
         .toLowerCase();
    System.err.println( s );

    char[] array = s.toCharArray();

    for ( int i = 0, j = array.length - 1; i <= j; i++, j-- ) {

      if ( array[i] != array[j] ) {
        return false;
      }
    }

    return true;
  }
}
