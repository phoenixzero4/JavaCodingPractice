package leetcode.easy;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

public class BestTimeToBuyStock {

	static int maxProfit( int[] prices ) {

		int min = Integer.MAX_VALUE;
		int best = 0;

		for ( int price : prices ) {
			if ( price < min ) {
				min = price;
			}

			int gain = price - min;
			if ( gain > best ) {
				best = gain;
			}
		}
		return best;
	}

	static void main( String[] args ) {

		int[] prices = {7, 1, 5, 3, 6, 4};
		/*
		 Output should be 5
		 Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
		 Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
		 */

		int result = maxProfit(prices);
		System.out.println(result);

		int[] prices2 = {7, 6, 4, 3, 1};
		/*
		Output should be 0
		In this case, no transactions are done and the max profit = 0.
		 */

		int result2 = maxProfit(prices2);
		System.out.println(result2);

	}
}
