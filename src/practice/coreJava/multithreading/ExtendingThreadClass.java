package practice.coreJava.multithreading;

class MyThreadOne extends Thread {

	public void run() {

		System.out.println(this.getName() + " created and running");

	}
}

class MyThreadTwo extends Thread {

	public void run() {

		System.out.println(this.getName() + " created and running");

	}
}

class MyThreadThree extends Thread {

	public void run() {

		System.out.println(this.getName() + " created and running");
		
	}
}

public class Main {

	static void main( String[] args ) {

		Thread one = new MyThreadOne();

		Thread two = new MyThreadTwo();

		one.start();
		two.start();

		Thread three = new MyThreadThree();
		three.start();




	}

}
