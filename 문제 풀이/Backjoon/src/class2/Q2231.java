package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // M의 분해합이 N
        // N의 생성자는 M
        // N의 가장 작은 생성자
        // M의 분해합이 N 인 가장작은 값 M
        int n = Integer.parseInt(br.readLine());

        br.close();
        int result = 0;
        for(int i=1; i<n; i++) {
            // 분해합
            int total = i;
            // 나머지계산
            int target = i;
            int length = String.valueOf(i).length();

            //  for (int i = N - (length*9); i <= N; i++) {
            //  분해합의 최소 값은 각각 자리수의 최대값인 9를 더해서 뺀값
            for(int j=length-1; j>=0; j--) {
                // length == 3 => 0, 10 100,
                total +=target/Math.pow(10, j);
                target %=Math.pow(10, j);
            }

            if (total == n) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
