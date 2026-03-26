package bruteForce;

import java.io.*;
import java.util.*;

public class Q14501XXX {
    static int num;
    static int[][] sche;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());


        StringTokenizer st;
        sche = new int[num+1][2];

        for (int i=1; i<=num; i++) {
            st = new StringTokenizer(br.readLine());
            sche[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        int end = 1;
        int maxValue = maxDay(end);

        System.out.print(maxValue);
    }

    static int maxDay(int end) {
        int day = sche[end][0];
        int money = sche[end][1];
        end += day;
        while (end <= num) {
            money += maxDay(end);
        }
        return money;
    }
}
