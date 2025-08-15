package class3.sliver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 1 <= C <=100 컴퓨터의 수
 * S 컴퓨터 쌍의 수
 * N M 컴퓨터 번호, 연결된 컴퓨터 번호 (컴퓨터 쌍)
 *
 *
 */
public class Q2606 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = read();

        int S = read();

        boolean[][] computer = new boolean[C + 1][C + 1];
        for(int i=0; i<S; i++) {
            int a = read();
            int b = read();
            computer[a][b] = true;
            computer[b][a] = true;
        }

        boolean[] isVir = new boolean[C+1];
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        isVir[1] = true;
        while(!stack.isEmpty()) {
            int target  = stack.pop();

            for (int i=1; i<C+1; i++) {
                if (computer[target][i] && !isVir[i]) {
                    isVir[i] = true;
                    stack.add(i);
                }
            }
        }

        int count = 0;
        for(int i=1; i<C+1; i++) {
            if(isVir[i]) {
                count++;
            }
        }
        bw.write(String.valueOf(count-1));
        bw.flush();
        bw.close();
    }

    static int read() throws IOException {
        int num = System.in.read() & 15;
        int input;
        while ((input = System.in.read()) > 32) {
            num = (num << 3) + (num << 1) + (input & 15);
        }
        return num;
    }
}

