package class2.sliver;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q2751 {
    /**
     *  카운팅 정렬
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int num = Integer.parseInt(br.readLine());
        boolean[] answer = new boolean[2000001];

        for(int i=0; i<num; i++) {
            answer[Integer.parseInt(br.readLine())+ 1000000] = true;
        }


        for(int i = 0; i < answer.length; i++) {
            if(answer[i]) {
                sb.append((i - 1000000)).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static void answer1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] array = new int[num];

        for(int i=0; i<num; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        for(int i=0; i<num; i++) {
            if (i==0 || !(array[i] == array[i-1])) {
                bw.write(String.valueOf(array[i]));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
