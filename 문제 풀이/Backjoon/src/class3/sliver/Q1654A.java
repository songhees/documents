package class3.sliver;

import java.io.IOException;

/**
 * 1 <= K랜선의 개수 <= 10 000 1 <= N 필요한 랜선개수 <= 1000 000
 * k <= N
 * 이분 탐색
 */
public class Q1654A {
    public static void main(String[] args) throws IOException {
        int K = read();
        int N = read();

        long[] array = new long[K];
        long max = 0;
        for(int i=0; i<K; i++) {
            array[i] = read();
            max += array[i];
        }
        max /= N;
        long min = 1;
        long result = 0;

        while (min <= max) {
            long mid = (max+min)/2;

            int num = 0;
            for (int i=0; i<K; i++) {
                num += array[i]/mid;
            }

            if (num >= N) {
                min = mid + 1;
                result = mid;
            } else if (num < N) {
                max = mid - 1;
            }
        }
        System.out.println(result);
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
