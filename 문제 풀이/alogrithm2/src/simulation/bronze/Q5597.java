package simulation.bronze;

import java.io.*;
import java.util.*;

public class Q5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[31];
        for (int i=1; i<=28; i++) {
            nums[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=30; i++) {
            if (nums[i] == 0) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
