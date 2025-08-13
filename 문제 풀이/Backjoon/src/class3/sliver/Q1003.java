package class3.sliver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * N 번째 피보나치 수
 *
 * T 개의 테스트 케이스
 * 각각의 수의 0, 1의 개수를 공백으로 구분해서 출력
 *
 */
public class Q1003 {
    static class Counting {
        int count1;
        int count0;

        Counting (int count0, int count1) {
            this.count0 = count0;
            this.count1 = count1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = read();

        for(int i=0; i<T; i++) {
            int num = read();
            Counting[] count = new Counting[num+2];

            count[0] = new Counting(1, 0);
            count[1] = new Counting(0, 1);
            if (num > 1) {
                for (int j=2; j<num+1; j++) {
                    count[j] = new Counting(count[j-1].count0 + count[j-2].count0,
                            count[j-1].count1 + count[j-2].count1);
                }
            }
            bw.write(count[num].count0 + " " + count[num].count1 + "\n");
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
