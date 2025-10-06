package programmers.stack;

import java.util.Stack;

public class Stack3 {
    public static void main(String[] args) {

        String s = ")()(";
        boolean result = solution(s);

        System.out.println(result);
    }

    static boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();

        for (char word : s.toCharArray()) {
            if ('(' == word) {
                stack.add(1);
            } else if (')' == word) {
                if (stack.isEmpty() || stack.peek() != 1) {
                    stack.add(3);
                    break;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
