package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1436 {
    /**
     * 제일 간단한게 최선이다...
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int i = 0;
        int result = 665;

        while (i != num) {
            result++;
            if (String.valueOf(result).contains("666")) {
                i++;
            }
        }
        System.out.println((result+""));
    }
}
