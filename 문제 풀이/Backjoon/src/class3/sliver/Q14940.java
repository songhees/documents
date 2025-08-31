package class3.sliver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2 <= n 세로크기, m 가로크기 <= 1000
 * 0 은 갈 수 없는 땅
 * 1 은 갈 수 있는 땅
 * 2 는 목표지점 2는 한개
 *
 * 각 지점에서 목표지점까지의 거리
 * 갈 수 없으면 0
 */
public class Q14940 {
    static int[][] root;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = read();
        int M = read();

        root = new int[N][M];
        dist = new int[N][M];
        int x = 0;
        int y = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                int data = read();
                root[i][j] = data;
                if (data == 2) {
                    dist[i][j] = 0;
                    x = i;
                    y = j;
                } else if (data == 0) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = -1;
                }
            }
        }

        BFS(x, y, N, M);

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void BFS(int x, int y, int N, int M) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});

        int[][] points = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!que.isEmpty()) {
            int[] data = que.poll();

            for (int[] point : points) {
                int value = dist[data[0]][data[1]];

                if (data[0]+point[0] >= 0 && data[0]+point[0] < N &&
                        data[1]+point[1] >= 0 && data[1]+point[1] < M &&
                        dist[data[0]+point[0]][data[1]+point[1]] == -1 &&
                        root[data[0]+point[0]][data[1]+point[1]] == 1) {

                        dist[data[0]+point[0]][data[1]+point[1]] = value+1;
                        que.add(new int[]{data[0]+point[0], data[1]+point[1]});
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
