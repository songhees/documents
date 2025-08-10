package class2.sliver;

import java.io.*;

/**
 * 다시 풀기
 */
public class Q1676X {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String result = String.valueOf(factor(Integer.parseInt(br.readLine())));

        br.close();
        bw.write(result);
        bw.flush();
        bw.close();
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
