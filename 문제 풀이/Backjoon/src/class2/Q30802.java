package class2;

import java.io.*;
import java.util.StringTokenizer;

public class Q30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =  Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer num = new StringTokenizer(br.readLine(), " ");
        int tNum = Integer.parseInt(num.nextToken());
        int penNum = Integer.parseInt(num.nextToken());

        int result = 0;
        for(int i=0; i<6; i++) {
            int value = Integer.parseInt(st.nextToken());

            result += (value/tNum);
            if (value%tNum != 0) {
                result++;
            }
        }

        bw.write(String.valueOf(result));
        bw.newLine();
        bw.append(String.valueOf(n/penNum)).append(" ").append(String.valueOf(n%penNum));

        bw.flush();
        br.close();
        bw.close();
    }
}
