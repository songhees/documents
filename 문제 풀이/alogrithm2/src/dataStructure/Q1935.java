package dataStructure;

import java.io.*;
import java.util.*;

public class Q1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        char[] strs = br.readLine().toCharArray();

        Deque<Double> deque = new ArrayDeque<>();

        Map<Character, Double> map = new HashMap<>();
        char alpa = 'A';
        for (int i=0; i<num; i++) {
            map.put(alpa++, Double.valueOf(br.readLine()));
        }

        for (char str : strs) {
            if (str >= 'A' && str <= 'Z') {
                deque.push(map.get(str));
            } else {
                double n = deque.poll();
                double m = deque.poll();
                switch (str) {
                    case '*': deque.push(m*n);
                        break;
                    case '/': deque.push(m/n);
                        break;
                    case '-': deque.push(m-n);
                        break;
                    case '+': deque.push(m+n);
                        break;
                    case '%': deque.push(m%n);
                        break;
                }
            }
        }
        System.out.printf("%.2f", deque.poll());
    }
}
