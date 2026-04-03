package simulation.bronze;

import java.io.*;
import java.util.*;

public class Q2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int min = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<num; i++) {
            min = (num-1)-i;
            for (int j=0; j<(num+i); j++) {
                if (min <= j) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        for (int i=num-2; i>=0; i--) {
            min = (num-1)-i;
            for (int j=0; j<(num+i); j++) {
                if (min <= j) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
