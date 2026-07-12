package leetcode.easy.longestCommonPrefix;

public class Solution {

	static void main( String[] args ) {

		String[] strings = {"flower", "flow", "flight"};
		String[] strings0 = {"reflower", "flow", "flight"};
		String[] strings1 = {"dog", "racecar", "car"};
		String[] strings2 = {"", ""};
		String[] strings3 = {"a"};
		String[] strings4 = {"", "", ""};
		String[] strings5 = {"flower", "flower", "flower"};

		System.out.println(longestCommonPrefix(strings));

	}

	public static String longestCommonPrefix2( String[] strings ) {

		String longestPrefix = "", prefix;

		if ( strings.length <= 1 ) {
			longestPrefix = strings[0];
		}

		int index = 0;
		for ( int i = 0; i < strings.length - 1; i++ ) {
			String string = strings[i];

			if ( index < string.length() ) {
				prefix = string.substring(0, ++index);
				//		System.err.println("Prefix: " + prefix + " from 0 -> " + index + " in " + string);
			} else {
				prefix = string.substring(0, index);
			}
			for ( int k = i + 1; k < strings.length; k++ ) {

				String word = strings[k].trim();
				String substring2 = word.substring(0, index);

				System.out.printf("string: %s word: %s\n", string, word);
				//			System.out.println(word.equals(string));
				if ( string.equals(word) ) {
					System.out.println("word " + word + " starts with " + prefix);

					System.out.printf("Prefix: %s substring2: %s\n", prefix, substring2);

					longestPrefix = substring2;
					++index;
				} else if ( word.startsWith(prefix) ) {
					longestPrefix = prefix;
				} else {
					longestPrefix = "";
					return longestPrefix;
				}
			}
		}

		if ( longestPrefix.isEmpty() ) {
			//		System.out.print("There is no common prefix in the array ");
			for ( String s : strings ) {
				System.out.print(s + " ");
			}
		}
		return longestPrefix;
	}

	public static String longestCommonPrefix( String[] strings ) {

		if ( strings == null || strings.length == 0 )
			return "";

		String prefix = strings[0];

		for ( int i = 0; i < strings.length; i++ ) {
			while ( strings[i].indexOf(prefix) != 0 ) {
				prefix = prefix.substring(0, prefix.length() - 1);

				if ( prefix.isEmpty() )
					return "";
			}
		}
		return prefix;
	}
}

