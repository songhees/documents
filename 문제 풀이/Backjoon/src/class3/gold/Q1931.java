package class3.gold;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 1 <= N 회의 수 <= 100 000
 * 1 <= 시작시간 끝시간
 * 한개의 회의실에서 할 수 있는 회의의 최대 개수 구하기
 */
public class Q1931 {
    static int[][] times;
    public static void main(String[] args) throws IOException {
        int N = read();

        times = new int[N][2];
        for (int i=0; i<N; i++) {
            times[i] = new int[]{read(), read()};
        }

        Arrays.sort(times, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            if (times[i][0] >= end) {
                end = times[i][1];
                count++;
            }
        }
        System.out.println(count);
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
