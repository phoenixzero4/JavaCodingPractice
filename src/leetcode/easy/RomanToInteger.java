package leetcode.easy.romanToInteger;

public class Solution {

	public static int romanToInt( String s ) {

		int prev = 0, value = 0;
		int sum = 0;
		for ( int i = s.length() - 1; i >= 0; i-- ) {
			value = getValue(s.charAt(i));
			if ( value < prev ) {
				sum -= value;
			} else {
				sum += value;
			}
			prev = value;
		}
		return sum;
	}

	public static int getValue( char c ) {

		switch ( c ) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			default:
				return 0;
		}
	}

	static void main( String[] args ) {

		String one = "LVIII";
		String two = "III";
		String three = "MCMXCIV";
		String four = "CM";
		String five = "XLIX";
		System.out.printf("\nTesting string %s = %d\n", five, romanToInt(five));
		System.out.printf("\nTesting string %s = %d\n", three, romanToInt(three));
		System.out.println();

	}

}