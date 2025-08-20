package class3.sliver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 1 <= n <= 1000
 */
public class Q11726 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = read();

        long[] array = new long[N+1];
        array[0] = array[1] = 1;
        for (int i=2; i<=N; i++) {
            array[i] = (array[i-1] + array[i-2])%10007;
        }
        bw.write(String.valueOf(array[N]));
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
