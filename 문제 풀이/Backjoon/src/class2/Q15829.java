package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15829 {
    // M 는 오버플로우를 막기위한 수의 상한선
    // 수학적으로 마지막에 M을 나누지만 컴퓨터에서는 오버플로우를 막기위해 중간에 M을 나눈다.
    // 어떤 수 x가 있을 때,
    //  (x % M) % M 은 그냥 x % M 와 똑같기 때문ㅇ
    // (result + (charD * power) % M) % M 는 (result + (charD * power)) % M 와 같다
    public static void main(String[] args) throws IOException {
        final int r = 31;
        final int M = 1234567891;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        String str = br.readLine();

        br.close();
        long result = 0;
        long power = 1;

        for (int i = 0; i < num; i++) {
            int charD = str.charAt(i) - 'a' + 1;
            result = (result + (charD * power) % M) % M;
            power = (power * r) % M;
        }

        System.out.println(result);
    }
}
