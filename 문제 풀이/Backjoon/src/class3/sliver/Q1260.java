package class3.sliver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * node개수 선개수 시작노드
 * 첫번째 DFS , 두번째 BFS
 *
 * 4 5 1
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 */
public class Q1260 {
    static boolean[][] array;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = read();
        int M = read();
        int V = read();

        array = new boolean[N+1][N+1];
        isVisited = new boolean[N+1];
        for(int i=0; i<M; i++) {
            int node = read();
            int next = read();

            array[node][next] = true;
            array[next][node] = true;
        }

        DFS(V);
        isVisited = new boolean[N+1];
        sb.append("\n");
        BFS(V);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void DFS(int n) {
        isVisited[n] = true;
        sb.append(n + " ");

        for(int i=1; i<array[n].length; i++) {
            if (!isVisited[i] && array[n][i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        isVisited[n] = true;
        sb.append(n + " ");

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for(int i=1; i<array[node].length; i++) {
                if (!isVisited[i] && array[node][i]) {
                    queue.add(i);
                    isVisited[i] = true;
                    sb.append(i + " ");
                }
            }
        }
    }

    static int read() throws IOException {
        int num = System.in.read() & 15;
        int input;
        while((input = System.in.read()) > 32) {
            num = (num << 3) + (num << 1) + (input & 15);
        }
        return num;
    }
}
