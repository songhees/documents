package implementation.bronze;

import java.io.*;
import java.util.*;

public class Q1924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        String[] name = new String[]{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int difference = 0;
        for (int i=0; i< month-1; i++) {
            difference += months[i];
        }

        difference += day;

        System.out.print(name[(difference-1)%7]);
    }
}
