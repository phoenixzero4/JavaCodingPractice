package hackerrank.certify.java.basic.typeCounter;

class Result {
    public static void typeCounter(String sentence) {
        int stringType = 0;
        int intType = 0;
        int doubleType = 0;

        String[] tokens = sentence.split(" ");
        for (String token : tokens) {
            if (isInteger(token)) {
                intType++;
            } else if (isDouble(token)) {
                doubleType++;
            } else {
                stringType++;
            }
        }

        System.out.println("string " + stringType);
        System.out.println("integer " + intType);
        System.out.println("double " + doubleType);
    }

    private static boolean isInteger(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private static boolean isDouble(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}

class Solution {
    public static void main(String[] args) {
        String sentence = "can you give me 10 bucks puff in 4.6 or 5";
        Result.typeCounter(sentence);
    }
}