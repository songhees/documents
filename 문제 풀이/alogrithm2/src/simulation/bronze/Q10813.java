package simulation.bronze;

import java.io.*;
import java.util.*;

public class Q10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] buckets = new int[N+1];

        for (int i=1; i<N+1; i++) {
            buckets[i] = i;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int temp = buckets[a];
            buckets[a] = buckets[b];
            buckets[b] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<N+1; i++) {
            sb.append(buckets[i] == 0 ? i : buckets[i]).append(" ");
        }
        System.out.print(sb.toString());
    }
}
