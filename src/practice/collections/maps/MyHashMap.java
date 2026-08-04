package practice.collections.maps;

import java.util.HashMap;

public class MyHashMap {

	static void main( String[] args ) {

		HashMap<Integer, Transaction> map = new HashMap<>();

	}

	class Transaction {

		double amount;
		double balance;
		String type;

		public Transaction( double amount, String type ) {

			this.amount = amount;
			this.type = type;
		}

		public double getBalance() {

			return this.balance;
		}

	}
}
