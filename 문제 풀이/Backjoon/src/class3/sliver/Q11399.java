package class3.sliver;

import java.io.IOException;
import java.util.Arrays;

/**
 * N 명의 사람
 *
 * 각 사람이 돈을 인출하는데 걸리는 시간을 나열
 * 각각의 사람이 돈을 인출하는데 걸리는 시간의 합의 최소값 구하기
 */
public class Q11399 {
    /**
     * 카운팅 정렬
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int N = read();

        int[] per = new int[1001];
        for(int i=0; i<N; i++) {
            per[read()]++;
        }

        int total = 0;
        for(int i=0; i<1000; i++) {
            while (per[i]-- > 0) {
                total += (i)*(N--);
            }
        }
        System.out.println(total);
    }

    /**
     * 일반 배열 사용
     * @param args
     * @throws IOException
     */
    public static void main1(String[] args) throws IOException {
        int N = read();

        int[] per = new int[N];
        for(int i=0; i<N; i++) {
            per[i] = read();
        }

        Arrays.sort(per);

        int total = 0;
        for(int i=0; i<N; i++) {
            total += per[i]*(N-i);
        }
        System.out.println(total);
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
