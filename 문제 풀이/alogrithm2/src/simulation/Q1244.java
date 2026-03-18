package simulation;

import java.io.*;
import java.util.*;

public class Q1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] status = new int[num+1];
        status[0] = 2;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=num; i++) {
            status[i] = Integer.parseInt(st.nextToken());
        }

        int peopleNum = Integer.parseInt(br.readLine());

        // 학생수 100개 이하
        for(int i=0; i<peopleNum; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                // 배수
                for (int j=target; j<num+1; j+=target) {
                    status[j] = (status[j] == 1) ? 0 : 1;
                }
            } else {

                int left = target;
                int right = target;

                // 투 포인트 
                while(left > 0 && right < num+1) {
                    if (status[left] == status[right]) {
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
                for (int j=(left+1); j<=(right-1); j++) {
                    status[j] = (status[j] == 1) ? 0 : 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<num+1; i++) {
            sb.append(status[i]).append(" ");
            if (i % 20 == 0) {
                sb.append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
