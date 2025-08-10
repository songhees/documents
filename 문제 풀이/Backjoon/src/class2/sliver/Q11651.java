package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11651 {
    /**
     * 좌표 정렬하기2
     * 1. 2차원 평면에 점 N개
     * 2. y좌표가 증가하는 순
     * 3. y좌표가 같으면 x좌표가 증가하는 순서로 정렬
     * @param args
     * @throws IOException
     */
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

        Arrays.sort(array, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        for (int i=0; i<num; i++) {
            int[] data = array[i];
            sb.append(data[0]).append(" ").append(data[1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
