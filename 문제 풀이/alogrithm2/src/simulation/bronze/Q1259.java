package simulation.bronze;

import java.io.*;
import java.util.*;

public class Q1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            String num = br.readLine();
            if (num.equals("0")) {
                break;
            }

            int start = 0;
            int end = num.length()-1;

            boolean isPalin = true;
            while (start < end) {
                if (num.charAt(start) == num.charAt(end)) {
                    start++;
                    end--;
                } else {
                    isPalin = false;
                    break;
                }
            }
            sb.append(isPalin ? "yes" : "no").append("\n");
        }
        System.out.print(sb.toString());
    }
}