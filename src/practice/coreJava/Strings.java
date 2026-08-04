package practice.coreJava;

import java.util.Random;

public class Strings {

	static void main( String[] args ) {


		String a = "";
		Random random = new Random();
		long start = System.currentTimeMillis();

		for ( int i = 0; i < 100000; i++ ) {
			int randInt = random.nextInt(65, 91);
			char c = (char) randInt;
			a += c + "";
		}

		long end = System.currentTimeMillis();
		int seconds = (int) (end - start) / 1000;
		int milli = (int) (end - start) % 1000;
		System.err.println("String time: " + seconds + " seconds " + milli + " ms");
		System.err.println("String size: 100,000\n");


		StringBuilder builder = new StringBuilder();
		start = System.currentTimeMillis();

		for ( int i = 0; i < 100000; i++ ) {
			int randInt = random.nextInt(65, 91);
			char c = (char) randInt;
			builder.append(c + "");
		}

		end = System.currentTimeMillis();
		seconds = (int) (end - start) / 1000;
		milli = (int) (end - start) % 1000;
		System.err.println("StringBuilder time: " + seconds + " seconds " + milli + " ms");
		System.err.println("Builder size: 100,000\n");



		StringBuffer buffer = new StringBuffer();
		start = System.currentTimeMillis();

		for ( int i = 0; i < 100000; i++ ) {
			int randInt = random.nextInt(65, 91);
			char c = (char) randInt;
			buffer.append(c + "");
		}

		end = System.currentTimeMillis();
		seconds = (int) (end - start) / 1000;
		milli = (int) (end - start) % 1000;
		System.err.println("StringBuffer time: " + seconds + " seconds " + milli + " ms");
		System.err.println("Buffer size: 100,000\n");

//		String one = "hello";
//		String two = "hello";
		// String c = new String("hello");
//		System.out.println("a: " + a.hashCode());
//		System.out.println("b: " + b.hashCode());
//		System.out.println("c: " + c.hashCode());
//		StringBuilder sb = new StringBuilder();
//		sb.append("Phoenix");
//		System.err.println(sb);
//		sb.delete(1, 2);
//		System.err.println(sb);
//		sb.replace(1, 1, "H");
//		System.err.println(sb);
//		System.err.println(sb.insert(sb.length(), " is awesome"));
//		sb.setLength(0);
//		System.err.println(sb);
	}

}
