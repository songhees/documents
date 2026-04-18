package implementation.bronze;

import java.io.*;

public class Q2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<num+1; i++) {
            for (int j=1; j<num+1; j++) {
                sb.append((num-i) < j  ? "*" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
