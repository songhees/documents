package class3.gold;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * D S L R
 * n = (  (d1 * 10 + d2)*10 + d3 ) * 10 + d4
 *   = d1*1000 + d2*100 + d3*10 + d4
 * D : n 을 두배로 바꾼다
 *      9999 보다 커지게 되면 10000으로 나눈 나머지가 된다.
 * S : n - 1
 *      n 이 0 이면 9999를 저장
 * L : d2 d3 d4 d1
 * R : d4 d1 d2 d3
 *
 * A 를 B로 바꾸는 최소한의 명령어
 *
 * T 테스트 케이스
 * 0 <= A B <= 10 000
 */
public class Q9019 {
    static String[] order;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = read();
        for (int i=0; i<T; i++) {
            int start = read();
            int end = read();
            BFS(start, end);
            sb.append(order[end]).append("\n");
        }
        System.out.println(sb);
    }

    static void BFS(int start, int end) {
        order = new String[10000];
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        order[start] = "";

        while (!que.isEmpty()) {
            int data = que.poll();

            if (data == end) {
                return;
            }

            int D = data*2 > 9999 ? (data*2)%10000 : data*2;
            if (order[D] == null) {
                que.add(D);
                order[D] = order[data] + "D";
            }

            int S = data-1 == -1 ? 9999 : data-1;
            if (order[S] == null) {
                que.add(S);
                order[S] = order[data] + "S";
            }

            int L = (data%1000)*10 + data/1000;
            if (order[L] == null) {
                que.add(L);
                order[L] = order[data] + "L";
            }

            int R = (data/10) + (data%10)*1000;
            if (order[R] == null) {
                que.add(R);
                order[R] = order[data] + "R";
            }
        }
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
