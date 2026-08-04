package interviews.wipro;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Questions {

	/* Using streams, return the first non-repeating character in the string "Swiss" */

	static char firstNonRepeatingCharacter( String s ) {

		Character result = s.toLowerCase()
				.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entry -> entry.getValue() == 1L)
				.map(entry -> entry.getKey())
				.findFirst()
				.orElse(null);

		return result;
	}

	static char firstNonRepeatingCharacter2( String s ) {

		Character result = s.chars()
				.mapToObj(c -> (char) c)
				.filter(ch -> s.indexOf(ch) == s.lastIndexOf(ch))
				.findFirst()
				.orElse(null);

		return result;
	}

	static void main( String[] args ) {

		String s = "swiss";
		System.out.println(firstNonRepeatingCharacter2(s));
	}
}
