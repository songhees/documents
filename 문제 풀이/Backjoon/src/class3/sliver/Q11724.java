package class3.sliver;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 1 <= 정점개수 N <= 1000 0 <= 간선 개수 M <= N*(N-1)/2
 */
public class Q11724 {
    static boolean[] isVisited;
    static ArrayList<Integer>[] array;

    public static void main(String[] args) throws IOException {
        int N = read();
        int M = read();
        array = new ArrayList[N+1];
        isVisited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            int point = read();
            int next = read();
            array[point].add(next);
            array[next].add(point);
        }

        int start = 1;
        int result = 0;
        while (true) {
            findLine(start);

            boolean isValid = true;
            for(int i=1; i<=N; i++) {
                if (!isVisited[i]) {
                    isValid = false;
                    start = i;
                }
            }

            result++;
            if (isValid) {
                break;
            }
        }
        System.out.println(result);
    }

    static void findLine(int no) {
        isVisited[no] = true;

        for(int data : array[no]) {
            if (!isVisited[data]) {
                findLine(data);
            }
        }
    }

    static int read() throws IOException {
        int num = System.in.read() & 15;
        int input;
        while((input = System.in.read()) > 32) {
            num = (num << 3) + (num << 1) + (input & 15);
        }
        return num;
    }
}
