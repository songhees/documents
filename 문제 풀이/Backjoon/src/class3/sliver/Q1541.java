package class3.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 괄호를 통해 값의 최소값을 만들기
 * 식의 길이 <= 50
 */
public class Q1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data = br.readLine();
        String[] minus = data.split("-");

        int result = Integer.parseInt(minus[0]);
        for(int i=1; i<minus.length; i++) {
            String[] plus = minus[i].split("[+]");

            int mi = 0;
            for(int j=0; j< plus.length; j++) {
                mi += Integer.parseInt(plus[j]);
            }
            result -= mi;
        }
        System.out.println(result);
    }
}
