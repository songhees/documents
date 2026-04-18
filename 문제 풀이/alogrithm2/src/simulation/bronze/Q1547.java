package simulation.bronze;

import java.io.*;
import java.util.*;

public class Q1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int location = 1;
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == location) {
                location = b;
            } else if (b == location) {
                location = a;
            }
        }
        System.out.print(location);
    }
}
