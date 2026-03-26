package dataStructure;

import java.io.*;
import java.util.*;

public class Q17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] exist = new int[1000001];
        int[] array = new int[num];
        for(int i=0; i<num; i++) {
            int value = Integer.parseInt(st.nextToken());

            array[i] = value;
            exist[value]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();

        int[] results = new int[num];
        for (int i=0; i<num; i++) {
            while(!deque.isEmpty() && exist[array[deque.peek()]] < exist[array[i]]) {
                results[deque.pop()] = array[i];
            }
            deque.push(i);
        }

        while(!deque.isEmpty()) {
            results[deque.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int result : results) {
            sb.append(result).append(" ");
        }
        System.out.print(sb.toString());
    }
}
