package implementation.bronze;

import java.io.*;
import java.util.*;

public class Q2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        StringBuilder sb = new StringBuilder();
        for (int i=2; i>=0; i--) {
            if (A.charAt(i) > B.charAt(i)) {
                sb.append(A);
                break;
            } else if (A.charAt(i) < B.charAt(i)) {
                sb.append(B);
                break;
            }
        }
        System.out.print(sb.reverse());
    }
}
