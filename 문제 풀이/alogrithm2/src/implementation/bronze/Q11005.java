package implementation.bronze;

import java.io.*;
import java.util.*;

public class Q11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int jin = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while(num > 0) {
            sb.append(num%jin >= 10 ? Character.toString((num%jin + 55)) : num%jin);
            num /= jin;
        }
        System.out.println(sb.reverse());
    }
}
