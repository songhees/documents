package programmers.stack;

import java.util.*;

public class Stack2 {
    public static void main(String[] args) {

        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};
        List<Integer> name = solution(progresses, speeds);

        System.out.println(name);
    }

    static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int days = 0;
        int count = 0;
        for (int i=0; i<progresses.length; i++) {
            if (days != 0 && progresses[i] + speeds[i]*days >= 100) {
                count++;
            } else if (days != 0 && progresses[i] + speeds[i]*days < 100) {
                answer.add(count);
                days = (int)Math.ceil((100.0-progresses[i])/speeds[i]);
                count = 1;
            } else if (days == 0) {
                days = (int)Math.ceil((100.0-progresses[i])/speeds[i]);
                count = 1;
            }
        }
        answer.add(count);
        return answer;
    }
}
