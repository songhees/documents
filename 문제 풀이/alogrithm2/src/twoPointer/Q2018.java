package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());

        int[] array = new int[target];
        // O(N)
        for (int i=0; i<target; i++) {
            array[i] = i+1;
        }

        int count = 0;

        int start = 0;
        int end = 0;
        int total = array[end];
        // O(N)
        while(start < target && end < target) {
            if (total == target) {
                count++;
                if (++end < target) {
                    total += array[end];
                }
            } else if (total < target) {
                end++;
                total += array[end];
            } else {
                total -= array[start];
                start++;
            }
        }

        // int total = 0;

        // while (true) {
        //     if (total >= target) {
        //         total -= array[start];
        //         start++;
        //     } else if (end == target) {
        //         // total이 target보다 작으면서 end가 배열 끝에 도달하면 탐색 종료
        //         break;
        //     } else {
        //         total += array[end];
        //         end++;
        //     }

        //     if (total == target) {
        //         count++;
        //     }
        // }

        System.out.println(count);
    }
}