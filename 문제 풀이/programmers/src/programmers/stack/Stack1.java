package programmers.stack;

import java.util.Arrays;
import java.util.Stack;

public class Stack1 {
    public static void main(String[] args) {

        int[] nums = new int[]{4, 4, 4, 3, 3};
        int[] name = solution(nums);

        System.out.println(Arrays.toString(name));
    }

    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int ar : arr) {
            if (!stack.isEmpty() && stack.peek() == ar) {
                continue;
            }
            stack.add(ar);
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
