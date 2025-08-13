package class2.sliver;

import java.io.*;

/**
 * 다시 풀기
 */
public class Q1676X {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String result = String.valueOf(factor1(Integer.parseInt(br.readLine())));

        br.close();
        bw.write(result);
        bw.flush();
        bw.close();
    }

    /**
     * 5의 배수 counting
     * @param n
     * @return
     */
    public static int factor1(int n) {
        int count = 0;
        int five = 5;
        while(five < n) {
            count += n/five;
            five *= 5;
        }
        return count;
    }

    public static int factor(int n) {
        long result = 1;
        int index = 0;
        for (int i=1; i<=n; i++) {
            result *= i;
            if (result % 10 == 0) {
                index++;
                result /= 10;
            }
        }
        return index;
    }
}
