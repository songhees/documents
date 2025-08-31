package class3.gold;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * T 테스트 케이스 <= 100
 * p 수행할 함수의 수 <= 100 000
 * R : 수의 순서를 뒤집기
 * D : 첫번째수 버리기
 *
 * n 배열의 수 <= 100 000
 *
 * 전체 T의 p + n <= 700 000
 *
 * 배열 안의 수는 정수
 */
public class Q5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        outer_loop: for (int i=0; i<T; i++) {

            String[] method = br.readLine().split("");
            int N = Integer.parseInt(br.readLine());
            Deque<String> que = new LinkedList<>();

            String txt = br.readLine();
            txt = txt.substring(1, txt.length()-1);

            if (!txt.isEmpty()) {
                for (String data : txt.split(",")) {
                    que.addFirst(data);
                }
            }

            boolean isFirst = true;
            for (int j=0; j< method.length; j++) {
                if ("R".equals(method[j])) {
                    isFirst = !isFirst;
                } else if ("D".equals(method[j])) {
                    String result = isFirst ? que.pollLast() : que.pollFirst();
                    if (result == null) {
                        sb.append("error\n");
                        continue outer_loop;
                    }
                }
            }

            sb.append("[");
            int size = que.size();
            for (int j=0; j<size; j++) {
                sb.append(isFirst ? que.pollLast() : que.pollFirst()).append(j < (size-1) ? "," : "");
            }
            sb.append("]\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}