package class3.sliver;

import java.io.IOException;

/**
 * N 나무의 수 M 나무의 길이 <= 2 000 000 000
 * 이분 탐색
 *
 */
public class Q2805 {
    public static void main(String[] args) throws IOException {
        int N = read();
        int M = read();
        int[] array = new int[N];
        int end = 0;
        for (int i=0; i<N; i++) {
            array[i] = read();

            if (end < array[i]) {
                end = array[i];
            }
        }

        int start = 1;
        int result = 0;
        while(start <= end) {
            int mid = (start+end)/2;
            long target = 0;

            for (int i=0; i<N; i++) {
                if (array[i] >= mid) {
                    target += (array[i]-mid);
                }
            }

            if (target >= M) {
                start = mid + 1;
                result = mid;
            } else if (target < M) {
                end = mid - 1;
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
