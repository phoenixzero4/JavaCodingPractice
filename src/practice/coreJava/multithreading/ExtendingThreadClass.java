package practice.coreJava.multithreading;

class MyThreadOne extends Thread {

	public void run() {

		Thread.currentThread().setName("Phil");

		System.out.println(this.getName() + " created and running");
	}
}

class MyThreadTwo extends Thread {

	public void run() {


		Thread.currentThread().setName("Bob");
		System.out.println(this.getName() + " created and running");

	}
}

class MyThreadThree extends Thread {

	public void run() {

		Thread.currentThread().setName("Dave");
		System.out.println(this.getName() + " created and running");
	}
}

public class ExtendingThreadClass {

	static void main( String[] args ) {

		Thread one = new MyThreadOne();

		Thread two = new MyThreadTwo();

		one.start();
		two.start();
		System.err.println("There are " + Thread.activeCount() + " threads now");

		Thread three = new MyThreadThree();
		three.start();




	}

}
