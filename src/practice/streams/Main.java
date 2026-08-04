package practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java Streams
 *
 */
public class Main {



	static void main( String[] args ) {

		// Creating a stream from a list
		List<String> list = List.of("Brodi", "Lael", "Leroy", "Kira", "Clyde");
		Stream<String> listStream = list.stream();

		// mapping all values in list to uppercase, filtering on startsWith("L") criteria, and returning a sorted list
		List<String> result = listStream
				.map(String::toUpperCase)
				.filter(name -> name.startsWith("L"))
				.sorted()
				.collect(Collectors.toList());

		System.out.println(result);

		// Create a stream from an array
		String[] array = {"apple", "blueberry", "grape", "cherry"};
		Stream<String> arrayStream = Arrays.stream(array);

		// Create a stream with Stream.builder()
		String[] colors = {"orange", "purple", "blue", "green", "red", "black", "white", "yellow", "brown"};
		Stream.Builder<String> streamBuilder = Stream.builder();

		for ( String str : colors ) {
			streamBuilder.accept(str);
		}

		Stream<String> stringStream = streamBuilder.build();
		List<String> startWithB = stringStream.filter(color -> color.startsWith("b")).collect(Collectors.toList());


		long numberOfColors = Stream.of(colors).filter(color -> color.startsWith("b")).count();
		System.out.println("There are " + numberOfColors + " colors that start with 'b' in the colors array");
		startWithB.forEach(System.out::println);

		// Directly
		Stream<Integer> intStream = Stream.of(10, 2, 35, 14, 5);
		intStream.forEach(System.out::println);

		/* This will not work because the stream has already been used and closed
			 An IllegalStateException will be thrown if a stream has been operated on previously
		 */
//		List<Integer> intList = intStream.sorted().filter(i -> i > 10).toList();
//		System.out.println(intList);





		//	System.out.println(result);
		/* Intermediate Operations (Transformations)
		 filter(Predicate)
		 map(Function)
		 sorted()
		 distinct()
		 limit(long n)
		 */

		/* Terminal Operations (Consumers)
		 collect(Collector) = gathers into a List, Set, or Map
		 forEach(Consumer) = iterates over each element for side effect (e.g. printing)
		 count() = returns the total number of elements
		 reduce() = combines stream into a single value
		 */

	}
}
