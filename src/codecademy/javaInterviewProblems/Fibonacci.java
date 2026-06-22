package codecademy.javaInterviewProblems;

import java.util.Scanner;

public class Fibonacci{

    public static long recursiveFib(int n){

        if( n <= 1 ){
            return n;
        }else{
            return (recursiveFib(n-1) + recursiveFib(n-2));
        }


    }



    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number to find the Fibonacci number: ");
        int n = scan.nextInt();
        scan.close();
        System.out.printf("The %dth Fibonacci number is %d", n, recursiveFib(n));
        System.out.printf(" (%d + %d)", recursiveFib(n-1), recursiveFib(n-2));
    }
}
