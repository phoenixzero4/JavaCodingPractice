package practice.strings;

//		Create a Java method that takes the String as input and returns the reversed string.
//			Example:
//		Input:  "automation"
//		Output: "noitamotua"

public class reverseStringMethods {

  static void main() {

    String a = "automation";
    System.out.println( a );
    System.err.println( reverseWithBuilder( a ) );
    System.err.println( reverseWithArray( a ) );
  }

  public static String reverseWithBuilder( String s ) {

    StringBuilder sb = new StringBuilder( s );
    sb = sb.reverse();

    return sb.toString();
  }

  public static String reverseWithArray( String s ) {

    String[] array = s.split( "" );
    String[] result = new String[s.length()];

    int j = 0;
    for ( int i = array.length - 1; i >= 0; i-- ) {
      String c = array[i];
      result[j++] = c;
    }

    return String.join( "", result );
  }
}
