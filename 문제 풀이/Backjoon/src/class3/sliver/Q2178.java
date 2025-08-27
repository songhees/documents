package class3.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
    static int[][] mi;
    static int[][] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        mi = new int[N][M];
        distance = new int[N][M];
        for(int i=0; i<N; i++) {
            String[] tile = br.readLine().split("");
            for(int j=0; j<M; j++) {
                mi[i][j] = Integer.parseInt(tile[j]);
            }
        }
        find(N, M);
        System.out.println(distance[N-1][M-1]+1);
    }

    static void find(int n, int m) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0});
        mi[0][0] = 0;

        while (!que.isEmpty()) {
            int[] point = que.poll();

            if (point[0] == n-1 && point[1] == m-1) {
                return;
            }

            int[][] position = {
                    {point[0]+1, point[1]}, {point[0]-1, point[1]}, {point[0], point[1]-1}, {point[0], point[1]+1}
            };

            for(int[] pos : position) {
                if (pos[0] >= 0 && pos[0] < n && pos[1] >= 0 && pos[1] < m && mi[pos[0]][pos[1]] != 0) {
                    mi[pos[0]][pos[1]] = 0;
                    que.add(new int[]{pos[0], pos[1]});
                    distance[pos[0]][pos[1]] = distance[point[0]][point[1]]+1;
                }
            }
        }
    }
}
