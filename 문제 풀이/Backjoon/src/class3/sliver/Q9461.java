package class3.sliver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * T : 테스트 케이스 개수
 * 1<= N <= 100 : 몇번째 삼각형?
 * 결과값 : 마지막 삼각형의 변의 길이
 */
public class Q9461 {
    static long[] tri = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = read();

        tri[1] = tri[2] = tri[3] = 1;
        tri[4] = tri[5] = 2;
        for(int i=1; i<=T; i++) {
            int N = read();
            for(int j=6; j<N+1; j++) {
                tri[j] = tri[j-1] + tri[j-5];
            }
            sb.append(tri[N] + "\n");
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
