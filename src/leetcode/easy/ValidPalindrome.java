package leetcode.easy;

import java.util.Scanner;

import static practice.SystemMethods.*;

public class ValidPalindrome
	{

		public static boolean isPalindrome( String s )
			{

				s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

				int i = 0, j = s.length() - 1;
				while ( i < j )
					{
						if ( s.charAt(i++) != s.charAt(j--) )
							{
								return false;
							}
					}
				return true;
			}

		static void main()
			{
				//	SystemMethods sm = new SystemMethods();

				Scanner in = new Scanner(System.in);
				System.out.println("\nEnter a string to test: ");

				String input = in.nextLine();

				System.out.print(MAGENTA + UNDERLINE + "Ignoring case and " + "removing non " + "alphabetic " + "characters " + RESET);
				if ( isPalindrome(input) )
					{
						System.out.println(BRIGHT_BLUE + BOLD + "'" + input + "'" + RESET + GREEN + " is a " + "palindrome" + RESET);
					} else
					{
						System.out.println(BLUE + "'" + input + "'" + RESET + GREEN + " is NOT a " + "palindrome");
					}
			}
	}

