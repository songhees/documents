package simulation;

import java.io.*;
import java.util.*;

public class Q13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int maxW = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> bridge = new LinkedList<>();

        
        // 다리
        int count = 0;
        int[] trucks = new int[num];
        for (int i=0; i<num; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }
        int nextTruck = 0;
        int totalW = 0;
        do {
            // 트럭이 이동
            if (bridge.size() == width) {
                totalW -= bridge.poll();
            }

            if (nextTruck < num && (totalW+trucks[nextTruck]) <= maxW) {
                bridge.add(trucks[nextTruck]);
                totalW += trucks[nextTruck];
                nextTruck++;
            } else {
                bridge.add(0);
            }

            count++;
        } while (totalW > 0);
        System.out.print(count);
    }
}
