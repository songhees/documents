package bruteForce;

import java.io.*;
import java.util.*;

public class Q2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int[] people = new int[9];
        int total = -100;
        for (int i=0; i<9; i++) {
            int length = Integer.parseInt(br.readLine());
            people[i] = length;
            total += length;
        }

        target : for (int i=0; i<9; i++) {
            for(int j=i+1; j<9; j++) {
                if (total == (people[i]+people[j])) {
                    people[i] = 0;
                    people[j] = 0;
                    break target;
                }
            }
        }
        Arrays.sort(people);

        for (int i=2; i<9; i++) {
            sb.append(people[i]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
