package simulation.bronze;

import java.io.*;
import java.util.*;

public class Q2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<num; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] apart = new int[k+1][n+1];

            for (int z=1; z<=n; z++) {
                apart[0][z] = z;
            }

            for (int j=1; j<=k; j++) {
                for (int z=1; z<=n; z++) {
                    apart[j][z] = apart[j-1][z];
                    if (z > 1) {
                        apart[j][z] += apart[j][z-1];
                    }
                }
            }
            sb.append(apart[k][n]).append("\n");
        }        
        System.out.print(sb.toString());
    }
}
