package hackerrank.certify.problemSolving.niceTeams;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result{

    public static int maxPairs(List<Integer> skillLevel, int minDiff){

        int result = 0;
        int maxSoFar = Integer.MIN_VALUE;
        int diff = 0;

        for(int i = 0; i < skillLevel.size(); i++){

            for(int j = i+1; j < skillLevel.size(); j++){
                diff = Math.abs(skillLevel.get(i) - skillLevel.get(j));
                if(diff <= minDiff){
                    maxSoFar++;
                }

            }
            result = Math.max(result, maxSoFar);
            maxSoFar = 0;
        }
        return result;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int skillLevelCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> skillLevel = IntStream.range(0, skillLevelCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

        int minDiff = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.maxPairs(skillLevel, minDiff);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
