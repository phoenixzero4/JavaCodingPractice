package practice.coreJava.generics;

import java.util.ArrayList;

public class Main {

	public static int vArgs( int i, String s, String... x ) {

		int total = 0;
		System.out.println("i: " + i);
		System.out.println("s: " + s);
		System.out.println("x:" + x);

		for ( String str : x ) {
			System.out.println(str);
		}
		total = x.length;
		return total;
	}

	public static <T> ArrayList<T> anyType( T[] array, ArrayList<T> list ) {

		int index = 0;

		for ( T object : array ) {
			list.add(object);

			System.out.println(++index + ": " + object);
		}
		return list;
	}

	static void main( String[] args ) {

		Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
		String[] strings = {"Brodi", "Leroy", "Lael", "Kira"};

		System.out.println(anyType(ints, new ArrayList<>()));
		System.out.println(anyType(strings, new ArrayList<>()));

		System.out.println(vArgs(2, "Brodi", "Leroy", "Lael", "Kira", "Phoenix"));
	}

}
