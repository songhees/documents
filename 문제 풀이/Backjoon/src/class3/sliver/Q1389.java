package class3.sliver;

import java.io.IOException;
import java.util.*;

/**
 * 케빈 베이컨
 * 한 사람이 모든 사람을 만나기 위한 최소 값의 합이 제일 작은 사람
 * 2 <= N 유저수 <= 100 1 <= M 친구 관계수 <= 5000
 */
public class Q1389 {
    static Set<Integer>[] array;

    public static void main(String[] args) throws IOException {
        int N = read();
        int M = read();

        array = new HashSet[N+1];
        for (int i=1; i<=N; i++) {
            array[i] = new HashSet<>();
        }

        for (int i=0; i<M; i++) {
            int A = read();
            int B = read();
            array[A].add(B);
            array[B].add(A);
        }

        int isMin = (N*(N-1))/2;
        int result = 0;
        for (int i=1; i<=N; i++) {
            int min = BFS(i, N);
            if (isMin > min) {
                isMin = min;
                result = i;
            }
        }

        System.out.println(result);
    }

    static int BFS(int n, int N) {
        Queue<Integer> queue = new LinkedList<>();
        int[] num = new int[N+1];
        Arrays.fill(num, -1);
        num[n] = 0;

        int min = 0;
        queue.add(n);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for(int data : array[node]) {
                if (num[data] == -1) {
                    queue.add(data);
                    num[data] = (num[node]+1);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            min += num[i];
        }

        return min;
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
