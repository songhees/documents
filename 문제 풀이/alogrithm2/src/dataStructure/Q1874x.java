package dataStructure;

import java.io.*;
import java.util.*;

public class Q1874x {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] array = new int[num];
        for (int i=0; i<num; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int start = 1;
        int count = 0;
        int end = 0;
        impossible : for (int target : array) {
            while (true) {
                if (end > num) {
                    break impossible;
                }

                if (target == end) {
                    stack.pop();
                    sb.append("-").append("\n");
                    count++;
                    break;
                } else {
                    start++;
                    stack.push(start);
                    sb.append("+").append("\n");
                }
            }

        }

        String result;
        if (count == num) {
            result = sb.toString();
        } else {
            result = "NO";
        }
        System.out.print(result);
    }
}
