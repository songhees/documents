package class3.sliver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * DFS, 매 턴 마다 isVisited 초기화
 * 특정 숫자를 중복으로 지나치지 않고 해당 정점에 도착할 수 있는가?
 */
public class Q11403 {
    static boolean[] isVisited;
    static int[][] root;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = read();

        root = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                root[i][j] = read();
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                isVisited = new boolean[N+1];
                BFS(i, j, N);
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                sb.append(root[i][j] + " ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void BFS(int start, int end, int N) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while (!que.isEmpty()) {
            int data = que.poll();

            for (int i=1; i<=N; i++) {
                if (root[data][i] == 1 && !isVisited[i]) {
                    if (i == end) {
                        root[start][end] = 1;
                        return;
                    }
                    isVisited[i] = true;
                    que.add(i);
                }
            }
        }
    }
    static int read() throws IOException {
        int num = System.in.read() & 15;
        int input;
        while ((input = System.in.read()) > 32) {
            num = (num << 3) + (num << 1) + (input & 15);
        }
        return num;
    }
}
