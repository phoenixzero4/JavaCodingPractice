package hackerrank.certify.java.basic.adder;

import java.util.Scanner;

public class Solution {

    void main(String[] args) {

        Calculator adderObject = new Adder();

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.println(a + b);

        System.out.println("The sum is: " + adderObject.add(a, b));


    }

    abstract class Calculator {
        abstract int add(int a, int b);
    }

    class Adder extends Calculator {

        public Adder() {
        }

        @Override
        public int add(int a, int b) {
            return a + b;
        }
    }
}
