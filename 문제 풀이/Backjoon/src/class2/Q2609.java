package class2;

import java.io.*;
import java.util.StringTokenizer;

public class Q2609 {
    /**
     * 두 개의 자연수의 최대 공약수와 최소 공배수 찾기
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        br.close();

        int max;
        if (a > b) {
            max = gcd(a, b);
        } else {
            max = gcd(b, a);
        }

        bw.write(String.valueOf(max));
        bw.newLine();

        int min = (a*b)/max;

        bw.write(String.valueOf(min));

        bw.flush();
        bw.close();
    }

    // a > b

    /**
     * 유클리드 호제법
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }
}
