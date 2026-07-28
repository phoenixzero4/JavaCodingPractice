package leetcode;

import java.util.Stack;

public class ValidParentheses {

	public static boolean isValid2( String s ) {

		//	System.out.println("Testing string " + s);

		Stack<String> l = new Stack<>();
		if ( s.isEmpty() | s.isBlank() ) {
			return true;
		} else if ( s.length() < 2 ) {
			return false;
		} else {
			l = new Stack<>();
			String[] array = s.split("");
			String paren = "";

			for ( String str : array ) {
				if ( str.equals("(") || str.equals("[") || str.equals("{") ) {
					l.push(str);
					//	} else if ( str.equals(")") || str.equals("]") || str.equals("}") ) {
				} else if ( !l.isEmpty() ) {
					paren = l.pop();
					if ( str.equals(")") && !paren.equals("(") ) {
						return false;
					} else if ( str.equals("]") && !paren.equals("[") ) {
						return false;
					} else if ( str.equals("}") && !paren.equals("{") ) {
						return false;
					}
				} else {
					return false;
				}
			}
		}
//		}
		return l.isEmpty();
	}

	public static boolean isValid( String s ) {
		// 1. Safe short-circuit null and empty checks
		if ( s == null || s.isEmpty() || s.isBlank() ) {
			return true;
		}
		// Odd lengths can never be valid parentheses pairs
		if ( s.length() % 2 != 0 ) {
			return false;
		}

		Stack<Character> l = new Stack<>();

		// 2. Iterate by char to avoid heavy String array allocation
		for ( int i = 0; i < s.length(); i++ ) {
			char ch = s.charAt(i);

			if ( ch == '(' || ch == '[' || ch == '{' ) {
				l.push(ch);
			} else {
				// 3. Early exit if there is a closing bracket without an open one
				if ( l.isEmpty() ) {
					return false;
				}
				char open = l.pop();
				if ( (ch == ')' && open != '(') ||
						(ch == ']' && open != '[') ||
						(ch == '}' && open != '{') ) {
					return false;
				}
			}
		}
		return l.isEmpty();
	}

	static void main( String[] args ) {

		String s = "()";
		System.out.println(isValid(s));
//		String one = "()";
//		System.out.println("Testing string " + one + " " + isValid(one) + " expected: true\n");
//
//		String two = "(){}[]";
//		System.out.println("Testing string " + two + " " + isValid(two) + " expected: true\n");
//
//		String three = "((";
//		System.out.println("Testing string " + three + " " + isValid(three) + " expected: false\n");
//
//		String four = "([])";
//		System.out.println("Testing string " + four + " " + isValid(four) + " expected: true\n");
//
//		String five = "(){}}{";
//		System.out.println("Testing string " + five + " " + isValid(five) + " expected: false\n");
//
//		String six = "";
//		System.out.println("Testing string \"\" " + isValid(six) + " expected: true\n");
//
//		String seven = "[";
//		System.out.println("Testing string " + seven + " " + isValid(seven) + " expected: false\n");
//
//		String eight = "}}";
//		System.out.println("Testing string " + eight + " " + isValid(eight) + " expected: false\n");
	}

}
