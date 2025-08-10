package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10814 {
    /**
     * StringBuffer를 이용한 정렬
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringBuffer[] array = new StringBuffer[201];

        for(int i = 0; i < array.length; i++) {
            array[i] = new StringBuffer();
        }

        StringTokenizer st;
        for(int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            array[age].append(age).append(" ").append(name).append("\n");
        }

        StringBuffer sb = new StringBuffer();
        for(StringBuffer s : array) {
            sb.append(s);
        }

        System.out.println(sb);
    }

    public static void answer1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int num = Integer.parseInt(br.readLine());

        String[][] array = new String[num][2];

        StringTokenizer st;
        for(int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            array[i] = new String[]{st.nextToken(), st.nextToken()};
        }

        // 0 은 순서를 변경하지 않음....
        Arrays.sort(array);

        Arrays.stream(array).forEach(item -> sb.append(item[0]).append(" ").append(item[1]).append('\n'));
        System.out.println(sb);
    }
}
