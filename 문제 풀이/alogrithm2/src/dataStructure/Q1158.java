package dataStructure;

import java.io.*;
import java.util.*;

public class Q1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int no = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i=1; i<=num; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        int next = 0;
        while (!list.isEmpty()) {
            next += (no-1);
            int a = next/list.size();
            next -= (list.size()*a);

            sb.append(list.remove(next)).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append(">");
        System.out.print(sb.toString());
    }
}
