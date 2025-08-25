package class3.sliver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * N 세로  M 가로  B 인벤토리에 있는 블록수
 * 각 좌표의 높이
 * 최소 시간 과 가장 땅의 높이가 높은 경우의 수
 */
public class Q18111 {
    static int[][] array;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = read();
        int M = read();
        int B = read();

        array = new int[N][M];

        int max = 0;
        int min = 256;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int data = read();
                array[i][j] = data;
                if(max < data) {
                    max = data;
                }

                if (min > data) {
                    min = data;
                }
            }
        }

        // 블록 제거는 2초
        // 블록 놓기는 1초
        int minTime = 256*2*M*N;
        int height = 0;
        for(int i=min; i<=max; i++) {
            int time = 0;
            int blockNum = B;
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    // 블록 놓기
                    if (array[n][m] < i) {
                        time += (i - array[n][m]);
                        blockNum -= (i - array[n][m]);
                    // 블록 제거
                    } else {
                        time += (array[n][m] - i)*2;
                        blockNum += (array[n][m] - i);
                    }
                }
            }
            if (blockNum >= 0) {
                if (time < minTime) {
                    minTime = time;
                    height = i;
                } else if (time == minTime) {
                    height = i;
                }
            }
        }
        sb.append( minTime + " " + height);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
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
