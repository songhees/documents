package implementation.bronze;

import java.io.*;
import java.util.*;

public class Q10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int aLength = A.length();
        int bLength = B.length();
        StringBuilder sb = new StringBuilder();

        int plus = 0;
        while(aLength > 0 || bLength > 0) {
            int aNum = aLength > 0 ? Integer.parseInt(A.substring(aLength-1, aLength--)) : 0;
            int bNum = bLength > 0 ? Integer.parseInt(B.substring(bLength-1, bLength--)) : 0;

            sb.append((aNum + bNum + plus)%10);
            plus = (aNum + bNum + plus)/10;
        }
        if (plus == 1) {
            sb.append(plus);
        }
        System.out.print(sb.reverse());
    }
}