package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int num = Integer.parseInt(br.readLine());

        int[][] array = new int[num][2];

        StringTokenizer st;
        for (int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            array[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        int[] result = new int[num];

        for (int i=0; i<num; i++) {
            int[] target = array[i];
            for (int j=0; j<num; j++) {
                if (i == j) {
                    continue;
                }

                if (target[0] < array[j][0] && target[1] < array[j][1]) {
                    result[i] += 1;
                }
            }
        }

        Arrays.stream(result).forEach(item -> sb.append(item+1).append(" "));

        System.out.println(sb.toString().trim());
    }
}
