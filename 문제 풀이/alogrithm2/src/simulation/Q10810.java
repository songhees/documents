package simulation;

import java.io.*;
import java.util.*;

public class Q10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 큐 first in first out
        int bucketNum = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int[] buckets = new int[bucketNum];

        for (int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int ballNum = Integer.parseInt(st.nextToken());

            for (int j=start; j<=end; j++) {
                buckets[j] = ballNum;
            }
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(buckets).forEach(bucket -> sb.append(bucket).append(" "));

        System.out.print(sb.toString());
    }
}
