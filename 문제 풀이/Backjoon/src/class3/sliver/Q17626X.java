package class3.sliver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Q17626X {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = read();

        long[] array = new long[50001];

        array[1] = 1;
        for (int i=2; i<=N; i++) {
            if (isOne(i)) {
                array[i] = 1;
                continue;
            }

            int M = i/2; // M번으로 min 값 구하기
            long min = i;
            for(int j=1; j<=M; j++) {
                long target = array[j] + array[i-j];

                if (target < min) {
                    min = target;
                }
            }
            array[i] = min;
        }
        bw.write(String.valueOf(array[N]));
        bw.flush();
        bw.close();
    }

    static boolean isOne (int n) {
        int target = (int) Math.sqrt(n);
        return n == target*target;
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
