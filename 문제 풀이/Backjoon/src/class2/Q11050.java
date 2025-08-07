package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11050 {
    /**
     * 팩토리얼 재귀 로직
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();

        int result = calcu(n)/(calcu(k)*calcu(n-k));
        System.out.println(result);
    }

    public static int calcu(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n*calcu(n-1);
        }
    }
}
