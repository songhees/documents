package dfs;

import java.io.*;
import java.util.*;

public class Q2606 {
    static int[][] couple;
    static int[] targets;
    static int coupleNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int computNum = Integer.parseInt(br.readLine());
        coupleNum = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        couple = new int[coupleNum][2];
        // 바이러스에 감염된 컴퓨터는 0 보다 큰수를 갖음
        targets = new int[computNum+1];
        for(int i=0; i<coupleNum; i++) {
            st = new StringTokenizer(br.readLine());
            couple[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        dfs(1);

        int count = 0;
        for(int i=2; i<=computNum; i++) {
            if (targets[i] > 0) {
                count++;
            }
        }

        System.out.print(count);
    }

    static void dfs(int other) {
        if (targets[other] > 0) {
            return;
        } 
        targets[other]++;

        for (int i=0; i<coupleNum; i++) {
            if (couple[i][0] == other) {
                dfs(couple[i][1]);
            } else if (couple[i][1] == other) {
                dfs(couple[i][0]);
            }
        }
    }
}
