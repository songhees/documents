package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = 0;
        for (int i=0; i< num; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (value == 2 || value == 3) {
                count++;
                continue;
            }

            boolean valid = true;
            for (int j=2; j*j<=value; j++) {
                if (value%j == 0) {
                    valid = false;
                    break;
                }
            }

            if (valid && value != 1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
