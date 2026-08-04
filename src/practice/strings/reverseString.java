package practice.strings;

//		Create a Java method that takes the String as input and returns the reversed string.
//			Example:
//		Input:  "automation"
//		Output: "noitamotua"

public class reverseString
	{

		public static String reverse( String s )
			{

				String[] array = s.split("");
				String[] result = new String[s.length()];

				int j = 0;
				for ( int i = array.length - 1; i >= 0; i-- )
					{
						String c = array[i];
						result[j++] = c;
					}

				return String.join("", result);
			}

		static void main( String[] args )
			{

				String s = "automation";
				System.err.println(reverse(s));
			}
	}
