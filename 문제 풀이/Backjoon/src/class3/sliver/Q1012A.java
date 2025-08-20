package class3.sliver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 *
 * M가로길이 N세로길이 K배추수
 *
 * 1 <= M, N <= 50
 * 1 <= K <= 2500
 *
 * X가로좌표 Y세로좌표
 * 0 <= X <= M-1
 * 0 <= Y <= N-1
 *
 */
public class Q1012A {
    static int[][] array;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = read();

        for(int i=0; i<T; i++) {
            int M = read();
            int N = read();
            int K = read();

            // 밭 생성
            array = new int[M][N];
            for(int j=0; j<K; j++) {
                array[read()][read()] = 1;
            }

            int count = 0;
            for(int m=0; m<M; m++) {
                for (int n=0; n<N; n++) {

                    if (array[m][n] == 1) {
                        count++;
                        bfs(m,n, M, N);
                    }
                }
            }
            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void bfs(int m, int n, int M, int N) {
        if (m < 0 || n < 0 || m >= M || n >= N || array[m][n] == 0) {
            return;
        }

        array[m][n] = 0;

        bfs(m, n+1, M, N);
        bfs(m, n-1, M, N);
        bfs(m+1, n, M, N);
        bfs(m-1, n, M, N);
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