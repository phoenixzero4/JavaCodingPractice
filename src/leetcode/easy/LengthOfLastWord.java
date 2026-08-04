package leetcode.easy;

/*
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.
 */

public class LengthOfLastWord
	{

		public static int lengthOfLastWord2( String s )
			{

				String[] array = s.split(" ");
				String string = array[array.length - 1].trim();

				return string.length();
			}

		// Runs a little faster and does not create an unnecessary array
		public static int lengthOfLastWord( String s )
			{

				int i = s.length() - 1;
				int length = 0;

				while ( i >= 0 && s.charAt(i) == ' ' ) i--;

				while ( i >= 0 && s.charAt(i) != ' ' )
					{
						length++;
						i--;
					}
				return length;
			}

		static void main( String[] args )
			{

				String s = "fly     me to  the  moon     ";
				System.out.println(lengthOfLastWord(s));
			}
	}