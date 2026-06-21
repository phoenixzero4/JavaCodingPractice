package hackerrank.certify.problemSolving.maximumSubArray;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

class Result{

    public static long maxSubArrayValue(List<Integer> arr){

        long evenSum = 0, oddSum = 0;
        long maxSum = Integer.MIN_VALUE;
        long currentSum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.size(); i++) {

            if (i % 2 == 0) {
                evenSum += arr.get(i);
                System.err.println("Even: " + evenSum);
            } else {
                oddSum += arr.get(i);
                System.err.println("Odd: " + oddSum);


            }
        }
            currentSum = (long)(evenSum + oddSum) * (evenSum + oddSum);
            System.err.println("Current: " + currentSum);

            if(currentSum >= maxSum){
                maxSum = currentSum;
                System.err.println("Max: " + maxSum);
                currentSum = 0;
            }


        return maxSum;
    }
}
public class Solution {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
         //       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
         BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());
            List<Integer> numbers = readIntegers(bufferedReader, numbersCount);

            long result = Result.maxSubArrayValue(numbers);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
    }

    private static List<Integer> readIntegers(BufferedReader bufferedReader, int count) {
        return IntStream.range(0, count)
                .mapToObj(index -> readInteger(bufferedReader))
                .toList();
    }

    private static int readInteger(BufferedReader bufferedReader) {
        try {
            return Integer.parseInt(bufferedReader.readLine().trim());
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }
}
