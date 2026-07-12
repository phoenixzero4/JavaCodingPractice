package karat.interview.citi;/*
We are developing a payment transaction monitoring system that tracks accounts and their transactions.
The system can compute each account's current balance and basic statistics.

Definitions:
* An "account" has a unique accountId and an owner name.
* A "transaction" represents money moving in or out of an account.
  - DEPOSIT increases the account balance.
  - WITHDRAWAL decreases the account balance.
* "AccountManager" manages accounts and transactions and provides balance-related methods.

To begin with, we present you with two tasks:
1.1) Read through and understand the code below. Please take as much time as necessary and feel free to run it.
1.2) The test for AccountManager is not passing due to a bug in the code.
     Make the necessary changes to AccountManager to fix the bug.
*/

/*
We are extending our payment transaction monitoring system to support
basic analytics over transactions.

For this task, we want to calculate the average transaction amount per account.

2) Implement the function getAverageTransactionAmountByAccount in AccountManager that returns
the average transaction amount for each account.

Requirements:
- The result should associate each accountId with the average amount of its transactions.
- Both DEPOSIT and WITHDRAWAL transactions should be considered.
- Transaction amounts should be treated as absolute values when calculating averages.
- Accounts with no transactions should not appear in the result.
- Transactions always refer to valid accounts.

To assist you in testing this new function, we have provided the
testGetAverageTransactionAmountByAccount test.
*/

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum TransactionType {
	DEPOSIT,
	WITHDRAWAL
}

class Account {

	int accountId;
	String ownerName;

	Account( int accountId, String ownerName ) {

		this.accountId = accountId;
		this.ownerName = ownerName;
	}
}

class Transaction {

	int transactionId;
	int accountId;
	TransactionType type;
	double amount;     // Always positive in inputs
	long timestampSec; // Unix-style seconds (monotonic for tests)

	Transaction( int transactionId, int accountId, TransactionType type, double amount, long timestampSec ) {

		this.transactionId = transactionId;
		this.accountId = accountId;
		this.type = type;
		this.amount = amount;
		this.timestampSec = timestampSec;
	}
}

class AccountManager {

	Map<Integer, Account> accounts = new HashMap<>();
	List<Transaction> transactions = new ArrayList<>();

	void addAccount( Account account ) {

		accounts.put(account.accountId, account);
	}

	void addTransaction( Transaction tx ) {
		// Assume input transactions always refer to valid accounts for this question.
		transactions.add(tx);
	}

	// Returns the current balance for the given accountId.
	double getBalance( int accountId ) {

		double balance = 0.0;
		for ( Transaction tx : transactions ) {
			if ( tx.accountId == accountId ) {
				if ( tx.type == TransactionType.DEPOSIT ) {
					balance += tx.amount;
				}
				// Problem 1.2 exists because there is no condition to check for transaction type WITHDRAWAL
				// Adding this else if statement fixes that issue

				else if ( tx.type == TransactionType.WITHDRAWAL ) {
					balance -= tx.amount;
				}
			}
		}
		return balance;
	}

	// Solution for problem 2 although you are asked to use an absolute value as there is no
	// change (fractions of a dollar) in the transactions
	public Map<Integer, Double> getAverageTransactionAmountByAccount() {

		HashMap<Integer, Double> result = new HashMap<>();
		HashMap<Integer, Integer> numberOfTrans = new HashMap<>();
		double sum = 0, average = 0;
		double currentBalance;
		int totalTransactions = 0;

		for ( Transaction t : transactions ) {

			int id = t.accountId;

			// putting the number of transactions in a map for each account
			if ( numberOfTrans.containsKey(id) ) {
				numberOfTrans.put(id, numberOfTrans.get(id) + 1);
				currentBalance = t.amount;
				totalTransactions++;
				average = currentBalance / totalTransactions;

				System.out.printf("Account: %d has balance of %f and %f transactions so far", id, currentBalance, average);
			} else {
				numberOfTrans.put(id, 1);
			}

			result.put(id, average);
		}
		return result;
	}
//				if ( t.accountId == entry.getKey() ) {
//					System.err.println("id: " + t.accountId + " key: " + entry.getKey());
//
//					if ( numberOfTrans.containsKey(t.accountId) ) {
//						numberOfTrans.put(t.accountId, numberOfTrans.get(t.accountId) + 1);
//					} else {
//						numberOfTrans.put(t.accountId, 1);
//					}
//					if ( t.type == TransactionType.DEPOSIT ) {
//						System.out.printf("adding %f to account %d\n", t.amount, t.accountId);
//						sum += t.amount;
//						System.out.println("current sum: " + sum);
//					} else if ( t.type == TransactionType.WITHDRAWAL ) {
//						System.out.printf("subtracting %f from account %d\n", t.amount, t.accountId);
//						sum -= t.amount;
//						System.out.println("current sum: " + sum);
//					}
//				}
//				System.err.println("AccountId: " + t.accountId + " Balance: " + sum);
//				average = sum / numberOfTrans.get(t.accountId);
//				result.put(t.accountId, average);
//			}
//
//		}
//
//		System.out.println(average);

	public static class Solution {

		static Map<Integer, Double> numberOfTrans = new HashMap<>();

		static void main( String[] args ) {

			testGetBalance_basic();
			testGetBalance_multipleAccounts();
			testGetAverageTransactionAmountByAccount();
			System.out.println("All tests passed.");

		}

		private static void assertAlmost( double expected, double actual ) {

			Assert.assertTrue("Expected " + expected + " but got " + actual, Math.abs(expected - actual) <= 1.0E-4);
		}

		public static void testGetBalance_basic() {

			System.out.println("Running testGetBalance_basic");
			AccountManager mgr = new AccountManager();
			mgr.addAccount(new Account(1, "Alice"));

			mgr.addTransaction(new Transaction(101, 1, TransactionType.DEPOSIT, 100.0, 1000));
			mgr.addTransaction(new Transaction(102, 1, TransactionType.WITHDRAWAL, 30.0, 1010));
			mgr.addTransaction(new Transaction(103, 1, TransactionType.WITHDRAWAL, 20.0, 1020));
			mgr.addTransaction(new Transaction(104, 1, TransactionType.DEPOSIT, 10.0, 1030));

			// Expected balance: 100 - 30 - 20 + 10 = 60
			assertAlmost(60.0, mgr.getBalance(1));

			mgr.addTransaction(new Transaction(105, 1, TransactionType.WITHDRAWAL, 70.0, 1045));
			assertAlmost(-10.0, mgr.getBalance(1));
		}

		public static void testGetBalance_multipleAccounts() {

			System.out.println("Running testGetBalance_multipleAccounts");
			AccountManager mgr = new AccountManager();
			mgr.addAccount(new Account(1, "Alice"));
			mgr.addAccount(new Account(2, "Bob"));

			mgr.addTransaction(new Transaction(201, 1, TransactionType.DEPOSIT, 50.0, 2000));
			mgr.addTransaction(new Transaction(202, 2, TransactionType.DEPOSIT, 80.0, 2005));
			mgr.addTransaction(new Transaction(203, 1, TransactionType.WITHDRAWAL, 10.0, 2010));
			mgr.addTransaction(new Transaction(204, 2, TransactionType.WITHDRAWAL, 5.5, 2015));
			mgr.addTransaction(new Transaction(205, 2, TransactionType.WITHDRAWAL, 14.5, 2020));

			// Account 1: 50 - 10 = 40
			assertAlmost(40.0, mgr.getBalance(1));
			// Account 2: 80 - 5.5 - 14.5 = 60
			assertAlmost(60.0, mgr.getBalance(2));
		}

		public static void testGetAverageTransactionAmountByAccount() {

			System.out.println("Running testGetAverageTransactionAmountByAccount");
			AccountManager mgr = new AccountManager();

			mgr.addAccount(new Account(51, "Alice"));
			mgr.addAccount(new Account(72, "Bob"));
			mgr.addAccount(new Account(93, "Charlie")); // no transactions

			// Account 51: 100, 30, 20, 10 => avg = 160/4 = 40
			mgr.addTransaction(new Transaction(101, 51, TransactionType.DEPOSIT, 100.0, 1000));
			mgr.addTransaction(new Transaction(102, 51, TransactionType.WITHDRAWAL, 30.0, 1010));
			mgr.addTransaction(new Transaction(103, 51, TransactionType.WITHDRAWAL, 20.0, 1020));
			mgr.addTransaction(new Transaction(104, 51, TransactionType.DEPOSIT, 10.0, 1030));

			// Account 72: 80, 5.5, 14.5 => avg = 100/3 = 33.333...
			mgr.addTransaction(new Transaction(201, 72, TransactionType.DEPOSIT, 80.0, 2005));
			mgr.addTransaction(new Transaction(202, 72, TransactionType.WITHDRAWAL, 5.5, 2015));
			mgr.addTransaction(new Transaction(203, 72, TransactionType.WITHDRAWAL, 14.5, 2020));

			Map<Integer, Double> avg = mgr.getAverageTransactionAmountByAccount();

			assertAlmost(40.0, avg.get(51));
			assertAlmost(33.3333, avg.get(72));

			// Account 93 has no transactions -> should not be present
			Assert.assertFalse(avg.containsKey(93));
		}
	}
}