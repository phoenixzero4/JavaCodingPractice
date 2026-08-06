package leetcode.easy;

public class LongestCommonPrefix
	{

		static void main( String[] args )
			{

				String[] strings = {"flower", "flow", "flight"};
				String[] strings0 = {"reflower", "flow", "flight"};
				String[] strings1 = {"dog", "racecar", "car"};
				String[] strings2 = {"", ""};
				String[] strings3 = {"a"};
				String[] strings4 = {"", "", ""};
				String[] strings5 = {"flower", "flower", "flower"};

				System.out.println(longestCommonPrefix(strings));

			}

		public static String longestCommonPrefix( String[] strings )
			{

				if ( strings == null || strings.length == 0 )
					return "";

				String prefix = strings[0];

				for ( int i = 1; i < strings.length; i++ )
					{
						while ( strings[i].indexOf(prefix) != 0 )
							{
								prefix = prefix.substring(0, prefix.length() - 1);

								if ( prefix.isEmpty() )
									return "";
							}
					}
				return prefix;
			}
	}

