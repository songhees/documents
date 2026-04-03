package simulation.bronze;

import java.io.*;
import java.util.*;

public class Q9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == -1) {
                break;
            }

            int value = 0;
            String result = num + " =";
            for (int i=1; i<num; i++) {
                if (num%i == 0) {
                    value += i;
                    result += (" " + i + " +");
                }
            }

            if (value == num) {
                sb.append(result).deleteCharAt(sb.length()-1).append("\n");
            } else {
                sb.append(num).append(" is NOT perfect.").append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
