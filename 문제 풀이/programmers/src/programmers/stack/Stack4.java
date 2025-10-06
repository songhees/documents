package programmers.stack;

import java.util.*;

public class Stack4 {
    public static void main(String[] args) {

        int[] priorities = {2, 1, 3, 2, 4};
        int location = 3;
        int result = solution(priorities, location);

        System.out.println(result);
    }

    static int solution(int[] priorities, int location) {
        int[] order = new int[10];
        for (int pr : priorities) {
            order[pr]++;
        }

        // que 대신 index로 이동
        int end = 0;
        int start = 0;
        // 꺼낸 프로세스 넘버
        int out = 0;
        // 몇번째로 꺼냈는지
        int process = 0;
        while (true) {
            int max = 0;
            for (int i=9; i>=1; i--) {
                if (order[i] > 0) {
                    max = i;
                    break;
                }
            }

            if (priorities[start] < max) {
                if (start == location) {
                    location = end;
                }
                priorities[end++] = priorities[start];
                start++;
            } else {
                order[priorities[start]]--;
                process++;
                if (start++ == location) {
                    break;
                }
            }

            if (priorities.length <= start) {
                start = 0;
            }
            if (priorities.length <= end) {
                end = 0;
            }
        }

        return process;
    }
}
