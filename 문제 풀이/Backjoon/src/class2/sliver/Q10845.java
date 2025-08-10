package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10845 {
    /**
     * 큐 만들기
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack(10000);
        StringBuffer sb = new StringBuffer();

        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++) {
            String msg = br.readLine();

            switch (msg) {
                case "pop" : sb.append(stack.pop() + "\n"); break;
                case "size" : sb.append(stack.size() + "\n"); break;
                case "empty" : sb.append(stack.empty() + "\n"); break;
                case "front" : sb.append(stack.front() + "\n"); break;
                case "back" : sb.append(stack.back() + "\n"); break;
                default: {
                    stack.push(Integer.parseInt(msg.split(" ")[1]));
                }
            }

        }
        System.out.println(sb);
    }


    static class Stack {
        int[] stack;
        int num;
        int max;

        public Stack (int capacity) {
            max = capacity;
            num = 0;
            try {
                stack = new int[capacity];
            } catch (OutOfMemoryError e) {
                max = 0;
            }
        }

        public void push(int data) {
            if (num > max) {
                return;
            }
            stack[num++] = data;
        }

        public int pop() {
            if (num <= 0) {
                return -1;
            }

            int result = stack[0];

            for(int i=1; i< num; i++) {
                stack[i-1] = stack[i];
            }
            num--;
            return result;
        }

        public int size() {
            return num;
        }

        public int empty() {
            return num <=0 ? 1 : 0;
        }

        public int front() {
            if (num <= 0) {
                return -1;
            }
            return stack[0];
        }

        public int back() {
            if (num <= 0) {
                return -1;
            }
            return stack[num-1];
        }
    }
}
