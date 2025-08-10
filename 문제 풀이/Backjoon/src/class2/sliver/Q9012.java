package class2.sliver;


import java.io.IOException;
import java.util.Stack;

public class Q9012 {
    /**
     * Q4949A 랑 같음
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        int num = readNumber();

        while(num > 0) {
            Stack<Integer> stack = new Stack<>();

            int c;
            while ((c = System.in.read()) != '\n') {
                if (c == '(') {
                    stack.add(1);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != 1) {
                        stack.add(2);
                        readOthers();
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }

            num--;
        }

        System.out.println(sb);
    }

    static void readOthers() throws IOException {
        int c;
        while((c = System.in.read()) > 31) {

        }
    }

    static int readNumber() throws IOException {
        int number = 0;
        int c;
        while ((c = System.in.read()) > 32) { // 32는 공백의 아스키 코드
            number = 10 * number + (c - 48); // 문자를 숫자로 변환
        }
        return number;
    }
}
