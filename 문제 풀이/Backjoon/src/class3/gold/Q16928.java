package class3.gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1 <= N 사다리수, M 뱀의 수 <= 15
 * N개의 사다리 좌표와 이동하는 칸
 * M개의 뱀 좌표와 이동하는 칸
 */
public class Q16928 {
    static int[] map = new int[101];
    static boolean[] isVisited = new boolean[101];
    static int[] board = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = read();
        int M = read();

        for (int i=0; i<N; i++) {
            board[read()] = read();
        }

        for (int i=0; i<M; i++) {
            board[read()] = read();
        }

        BFS();

        bw.write(String.valueOf(map[100]));
        bw.flush();
        bw.close();
    }

    static void BFS () {
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        isVisited[1] = true;
        map[1] = 0;

        while (!que.isEmpty()) {
            int point = que.poll();

            if (point == 100) {
                return;
            }

            for (int i=1; i<=6; i++) {
                int next = point + i;

                if (next > 100) {
                    continue;
                }

                if (board[next] != 0) {
                    next = board[next];
                }

                if (!isVisited[next]) {
                    que.add(next);
                    map[next] = map[point] + 1;
                    isVisited[next] = true;
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
