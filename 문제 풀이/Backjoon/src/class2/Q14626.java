package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int index = str.indexOf("*");
        String[] data = str.split("");

        int cal = 0;
        for (int i=0; i<12; i++) {
            if (i == index) {
                continue;
            }

            if (i%2 == 0) {
                cal += Integer.parseInt(data[i]);
            } else {
                cal += Integer.parseInt(data[i])*3;
            }
        }

        // cal + * 의 일의 자리수는 last 여야된다.
        // 0인 경우 10이 나오므로 10으로 나눠줘야됨
        int last = (10-Integer.parseInt(data[12]))%10;
        int m = index%2 == 0 ? 1 : 3;
        int result = 0;

        for (int i=0; i<=9; i++) {
            if ((cal + (i*m))%10 == last) {
                result = i;
            }
        }

        System.out.println(result);

        br.close();
    }
}
