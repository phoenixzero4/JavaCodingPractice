package practice.coreJava.multithreading;

class CountingNumbers implements Runnable {

	private final int num;
	private int sum = 0;

	CountingNumbers( int num ) {

		this.num = num;
	}

	public int getSum() {

		return sum;
	}

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + " is counting to " + num);

		for ( int i = 1; i <= num; i++ ) {
			sum += i;
		}
		System.out.println("The sum of the numbers counting to " + num + " is " + sum);
	}
}

class SumThread implements Runnable {

	private final int sum;

	SumThread( int sumOne, int sumTwo ) {

		this.sum = sumOne + sumTwo;
	}

	public void run() {

		System.out.println(Thread.currentThread().getName() + " is combining the sums of the other threads for a total of" +
				" " + this.sum);
	}
}

public class ImplementingRunnable {

	static void main( String[] args ) {

		CountingNumbers counterOne = new CountingNumbers(30);
		CountingNumbers counterTwo = new CountingNumbers(29);

		Thread one = new Thread(counterOne, "Brodi");
		Thread two = new Thread(counterTwo, "Kira");

		one.start();
		two.start();

		try {
			one.join();
			two.join();
			Thread three = new Thread(new SumThread(counterOne.getSum(), counterTwo.getSum()));
			three.setName("Leroy");
			three.start();
		} catch ( InterruptedException ex ) {
			ex.printStackTrace();
		}
	}
}

