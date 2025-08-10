package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q4949A {
    /**
     * 문자를 stack에 넣으면서 없애기
     * ([ --- 입력하다가 [ 다음에 ]가 입력되면  [] 를 없애기
     * ([ --- ] 가 입력되면 [] 없애고
     * ( 다음 )가 오면 () 를 없애기
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {
        StringBuffer sb = new StringBuffer();

        int c;
        // 마지막 줄 . 까지 진행
        while((c = System.in.read()) != '.') {

            Stack<Integer> stack = new Stack<>();
            while (c > 31) {
                if (c == '(') {
                    stack.add(1);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != 1) {
                        stack.add(3);
                        read();
                        break;
                    }
                    stack.pop();
                } else if (c == '[') {
                    stack.add(2);
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != 2) {
                        stack.add(3);
                        read();
                        break;
                    }
                    stack.pop();
                }
                c = System.in.read();
            }

            if (stack.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);
    }

    static void read() throws Exception {
        int c;
        while ((c = System.in.read()) > 31) {}
    }

    public static void find() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while (true) {
            String data = br.readLine();

            if (data.equals(".")) {
                break;
            }
            char[] chars = data.toCharArray();

            Stack<Character> stack = new Stack<>();

            String pattern = "()[]";
            for(char c : chars) {
                if (pattern.contains(String.valueOf(c))) {
                    stack.add(c);
                }
            }

            String result = "yes";
            Stack<Character> other = new Stack<>();
            if (stack.size() % 2 == 0) {
                while (stack.size() > 1) {
                    char last = stack.pop();
                    char next = stack.peek();

                    if (last-next == 1 || last-next== 2) {
                        stack.pop();

                        while (!other.isEmpty() && !stack.isEmpty()) {
                            last = other.peek();
                            next = stack.peek();
                            if (last-next == 1 || last-next == 2) {
                                other.pop();
                                stack.pop();
                                continue;
                            } else {
                                break;
                            }
                        }
                    } else {
                        other.add(last);
                    }
                }

                if (!other.isEmpty()) {
                    result = "no";
                }
            } else {
                result = "no";
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
