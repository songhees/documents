package dataStructure;

import java.io.*;
import java.util.*;

public class Q17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] targets = new int[num];
        for (int i=0; i<num; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int max = 0;
        int start = 0;
        int end = 0;
        while (start < num) {
            if (targets[start] < targets[end]) {
                max = targets[end];
                sb.append(max).append(" ");
                start++;
            } else {
                end++;
                if (end >= num) {
                    sb.append(-1).append(" ");
                    start++;
                    end = start;
                }
            }
        }
        System.out.print(sb.toString());
    }
}
