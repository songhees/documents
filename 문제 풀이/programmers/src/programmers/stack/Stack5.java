package programmers.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 트럭이 다리를 건너려면 최소 몇  초가 걸리는지
 *
 * 1 <= 트럭 몇대 brigde_length <= 10 000
 * 1 <= 견디는 무개 weight <= 10 000
 * 1 <= truck_weights <= 10 000
 */
public class Stack5 {
    public static void main(String[] args) {
        int brigde_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        int result = solution(brigde_length, weight, truck_weights);
        System.out.println(result);
    }

    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int[] bridge = new int[bridge_length];

        Queue<Integer> que = new LinkedList<>();
        for (int truck : truck_weights) {
            que.add(truck);
        }

        int day = 0;
        int location = 0;
        while (!que.isEmpty()) {
            int truck = que.poll();

            bridge[location] = truck;
        }




        int answer = 0;

        return answer;
    }
}
