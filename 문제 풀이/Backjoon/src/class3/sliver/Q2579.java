package class3.sliver;

import java.io.*;

/**
 * 계단 아래에서 위까지 가는 게임
 *
 * 계단에서 얻을 수 있는 점수의 최대값
 * N 계단의 개수
 * 1 <= N <= 300
 * 1 <= 점수 <= 10 000
 */
public class Q2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 계단의 개수
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        int[][] array = new int[N+1][2];

        if (N == 1) {
            bw.write(String.valueOf(stairs[1]));
            bw.flush();
            bw.close();
            return;
        }

        array[1][0] = stairs[1];
        array[1][1] = 0; // 1번째 계단은 2칸 점프 불가능

        array[2][0] = stairs[1] + stairs[2];
        array[2][1] = stairs[2];

        for(int i=3; i<(N+1); i++) {
            array[i][0] = array[i-1][1] + stairs[i];
            array[i][1] = Math.max(array[i-2][0], array[i-2][1]) + stairs[i];
        }

        bw.write(String.valueOf(Math.max(array[N][0], array[N][1])));
        bw.flush();
        bw.close();
    }
}
