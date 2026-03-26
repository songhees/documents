package dataStructure;

import java.io.*;
import java.util.*;

public class Q17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split("");

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        boolean isReverse = true;
        for (int i=0; i<strs.length; i++) {
            if ((" ".equals(strs[i])) && isReverse) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(strs[i]);
                continue;
            }
            if ("<".equals(strs[i])) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                isReverse = false;
            }

            if (!isReverse) {
                sb.append(strs[i]);
            } else {
                stack.add(strs[i]);
            }

            if (">".equals(strs[i])) {
                isReverse = true;
            }
        }

        if (isReverse) {
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
        }
        System.out.print(sb.toString());
    }
}
