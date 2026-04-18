package implementation.sliver;

import java.io.*;
import java.util.*;

public class Q1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int result = num;

        for(int i=0; i<num; i++) {
            int[] counter = new int[26];
            String word = br.readLine();

            for (int j=0; j< word.length(); j++) {
                if (j == word.length()-1 || word.charAt(j) != word.charAt(j+1)) {
                    counter[word.charAt(j)-97]++;
                }
            }

            for (int count : counter) {
                if (count > 1) {
                    result--;
                    break;
                }
            }
        }
        System.out.print(result);
    }
}
