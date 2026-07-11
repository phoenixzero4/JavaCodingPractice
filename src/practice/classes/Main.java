package practice.myServer;

public class Main {

	static void main( String[] args ) {

		Bird robin = new Robin("robin", "red", 2);

		System.out.println(robin.talk());
		System.out.println(robin.eat());
		System.out.println(robin.fly());

		System.out.println();

		Bird penguin = new Penguin("penguin", "black/white", 6);

		System.out.println(penguin.talk());
		System.out.println(penguin.eat());
		System.out.println(penguin.fly());

	}

}
