package class3.sliver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 1<= N <= 11 개의 테스트 케이스
 *
 * 테스트 케이스마다 1,2,3의 합으로 나타내는 방법의 수 출력
 *
 */
public class Q9095X {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = read();

        int[] caseT = new int[N+1];
        for(int i=1; i<=N; i++) {







        }

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
