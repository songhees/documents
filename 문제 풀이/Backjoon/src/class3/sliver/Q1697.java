package class3.sliver;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Q1697 {
    static int[] array;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        int N = read();
        int M = read();

        int max = Math.max(N, M);
        array = new int[max+2];
        isVisited = new boolean[max+2];
        findM(N, max);

        System.out.println(array[M]);
    }

    static void findM(int n, int M) {
        isVisited[n] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty() ){
            int k = q.poll();

            if (k < 0 || k > M+1) {
                return;
            }

            if ( k*2 <= M+1 && !isVisited[k*2]) {
                isVisited[k*2] = true;
                array[k*2] = array[k]+1;
                q.add(k*2);
            }
            if ( k-1 >= 0 && !isVisited[k-1]) {
                isVisited[k-1] = true;
                array[k - 1] = array[k] + 1;
                q.add(k-1);
            }
            if ( k+1 <= M+1 && !isVisited[k+1]) {
                isVisited[k+1] = true;
                array[k+1] = array[k]+1;
                q.add(k+1);
            }
        }
    }


    private static final int MAX_POSITION = 100000;
    private static int[] time = new int[MAX_POSITION + 1];
    private static boolean[] visited = new boolean[MAX_POSITION + 1];
    static int findM2(int n, int M) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        time[n] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 동생을 찾은 경우, 현재까지 걸린 시간을 반환
            if (current == M) {
                return time[current];
            }

            // 이동할 수 있는 3가지 경우 탐색
            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int nextPos : nextPositions) {
                // 다음 위치가 유효한 범위(0~100,000)에 있고, 아직 방문하지 않았다면
                if (nextPos >= 0 && nextPos <= MAX_POSITION && !visited[nextPos]) {
                    visited[nextPos] = true;
                    time[nextPos] = time[current] + 1; // 시간 1 증가
                    queue.add(nextPos);
                }
            }
        }
        return n;
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
