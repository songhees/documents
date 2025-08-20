package class3.sliver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 1 <= N <= 100 000 N은 범위 대상
 * 1 <= M <= 100 000 M은 테스트 케이스 수
 *
 * 1 <= 범위 대상인 수 들 <= 1000
 *
 * 구간 i ~ j 까지의 수의 합
 * 1 <= i <= j <= N
 *
 */
public class Q11659 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = read();
        int M = read();

        int[] array = new int[N+1];
        array[0] = 0;
        for (int i=1; i<=N; i++) {
            array[i] = read() + array[i-1];
        }

        for(int h=0; h<M; h++) {
            int i = read();
            int j = read();
            sb.append((array[j] - array[i-1]) + "\n");
        }
        bw.write(String.valueOf(sb));
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
