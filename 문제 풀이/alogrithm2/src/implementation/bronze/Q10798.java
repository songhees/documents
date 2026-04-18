package implementation.bronze;

import java.io.*;
import java.util.*;

public class Q10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<String>[] q = new Deque[5];
        int maxLength = 0;
        for (int i=0; i<5; i++) {
            String[] words = br.readLine().split("");
            maxLength = Math.max(maxLength, words.length);
            q[i] = new ArrayDeque<>(List.of(words));
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<maxLength; i++) {
            for (int j=0; j<5; j++) {
                if (!q[j].isEmpty()) {
                    sb.append(q[j].pop());
                }
            }
        }

        System.out.print(sb.toString());
    }
}
