package implementation;

import java.io.*;
import java.util.*;

public class Q1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i<num; i++) {
            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int paperNum = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j=0; j<paperNum; j++) {
                queue.add(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int count = 0;
            while(true) {
                int[] current = queue.poll();
                boolean isMax = true;
                for (int[] que : queue) {
                    if (current[1] < que[1]) {
                        isMax = false;
                    }
                }

                if (isMax) {
                    count++;
                    if (current[0] == target) {
                        break;
                    }
                } else {
                    queue.add(current);
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb.toString());
    }
}
