package practice5;

import java.util.Scanner;
import java.util.Stack;

public class Q7 {

    /**
     * 비재귀적 구현
     * @param no
     * @param x
     * @param y
     */
    static void move(int no, int x, int y) {

        Stack<CallFrame> stack = new Stack<>();
        stack.push(new CallFrame(no, x, y, 0));

        while(!stack.isEmpty()) {
            CallFrame callFrame = stack.peek();

            if (callFrame.no <= 0) {
                stack.pop();
                continue;
            }

            switch (callFrame.state) {
                case 0 :
                    if (callFrame.no > 1) {
                        stack.push(new CallFrame(callFrame.no -1, callFrame.x , 6-callFrame.x-callFrame.y, 0));
                    }
                    callFrame.state = 1;
                    break;
                case 1 :

                    System.out.println("원반[" + callFrame.no + "]을 " + callFrame.x + "기둥에서" + callFrame.y + "기둥으로 옮김");
                    callFrame.state = 2;
                    break;
                case 2 :
                    if (callFrame.no > 1) {
                        stack.push(new CallFrame(callFrame.no -1, 6-callFrame.x-callFrame.y, callFrame.y, 0));
                    }
                    callFrame.state = 3;
                    break;
                case 3 :
                    stack.pop();
                    break;
            }
        }
    }


    static void moveOri(int no, int x, int y) {
        if(no > 1) {
            move(no -1, x, 6-x-y);
        }

        System.out.println("원반[" + no + "]을 " + x + "기둥에서" + y + "기둥으로 옮김");

        if (no > 1) {
            move(no - 1, 6-x-y, y);
        }
    }

    public static void result() {
        Scanner scan = new Scanner(System.in);

        System.out.println("원반 개수 : ");
        int n = scan.nextInt();

        move(n, 1, 3);
    }


    // 스택에 저장할 상태 정보를 위한 클래스
    static class CallFrame {
        int no;
        int x;
        int y;
        int state; // 0: recur(n-1) 호출 전, 1: System.out.println(n) 전, 2: recur(n-2) 호출 전

        CallFrame(int no, int x, int y, int state) {
            this.no = no;
            this.x = x;
            this.y = y;
            this.state = state;
        }
    }
}
