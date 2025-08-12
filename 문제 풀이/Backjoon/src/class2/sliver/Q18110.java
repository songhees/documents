package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q18110 {
    /**
     * 1. 난이도 정렬
     * 2. 상위 하위 15퍼 절삭
     * 3. 평균 반올림
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        // 몇명을 제외 하느냐
        int exp = (int) Math.round((num*0.3)/2);

        // 0 ~ (exp-1) , num-exp ~ num-1 까지
        int[] array = new int[num];
        for(int i=0;i<num; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        double result = 0;
        for(int i=exp; i< (num-exp); i++) {
            result += array[i];
        }

        System.out.println(Math.round(result/(num-(2*exp))));
    }
}
