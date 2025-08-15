package class3.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS 방식으로 푸는 방법
 */
public class Q1463A {
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        visited = new int[n + 1];
        visited[n] = 0;

        /**
         * visited 10^ 6 승 만들고
         * 1. 나눌때마다 해당 숫자에 방문 횟수 넣기
         주의할 점은 bfs로 하면 계산순서에 따라 먼저 1에 닿을 수가 있어서 최솟값이 안남옴
         그래서 dfs로 같은 단계끼리 탐색해야함
         큐를 사용해서 끊어주기
         for문을 돌릴때 q가 없을때까지 돌리기
         */
        bfs(n);

        System.out.println(visited[1]);


    }

    static void bfs(int t) {

        Queue<Integer> q = new LinkedList<>();
        q.add(t);

        while(!q.isEmpty() ){
            int k = q.poll();

            if(k==1){
                return;
            }

            if (k % 3 == 0 && visited[k / 3] == 0) {
                visited[k / 3] = visited[k] + 1;
                q.add(k / 3);
            }
            if (k % 2 == 0 && visited[k / 2] == 0) {
                visited[k / 2] = visited[k] + 1;
                q.add(k / 2);
            }

            if (k - 1 >= 0 && visited[k - 1] == 0) {
                visited[k - 1] = visited[k] + 1;
                q.add(k - 1);
            }
        }
    }
}
