package implementation.bronze;

import java.io.*;

public class Q1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().toUpperCase().split("");

        int[] counts = new int[26];

        for (String word : words) {
            counts[word.charAt(0)-65]++;
        }

        String result = "";
        int max = 0;
        for (int i=0; i<counts.length; i++) {
            if (max < counts[i]) {
                max = counts[i];
                result = Character.toString((i+65));
            } else if (max == counts[i]) {
                result = "?";
            }
        }
        System.out.print(result);
    }
}
