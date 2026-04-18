package simulation.bronze;

import java.io.*;
import java.util.*;

public class Q10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bucket = new int[N+1];

        for(int a=0; a<M; a++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for(int b=i; b<=j; b++) {
                bucket[b] = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<N+1; i++) {
            sb.append(bucket[i]).append(" ");
        }
        System.out.print(sb.toString());
    }
}
