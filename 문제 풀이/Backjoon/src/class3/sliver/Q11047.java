package class3.sliver;

import java.io.IOException;

/**
 * 동전 N개의 종류, 동전의 합 K
 * 필요한 동전 개수의 최소값
 * 동전의 가치는 1 이상의 수에 대한 배수
 * 동전의 가치는 오름차순으로 입력된다.
 */
public class Q11047 {
    public static void main(String[] args) throws IOException {
        int N = read();
        int M = read();

        int[] mon = new int[N];
        for (int i=0; i<N; i++) {
            int data = read();
            mon[i] = data;
        }

        int total = 0;
        for(int i=N-1; i>=0; i--) {
            total += (M / mon[i]);
            M %= mon[i];
        }

        System.out.println(total);
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
