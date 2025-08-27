package class3.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 5 <= N 지도의 크기 <= 25
 *
 * answer
 * 총단지수
 * 각단지내 집의 수를 오름차순으로 하나씩 출력
 */
public class Q2667 {
    static int[][] map;
    static ArrayList<Integer> dangi = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] tile = br.readLine().split("");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(tile[j]);
            }
        }

        // 지도를 돌면서 1이 있으면 단지 내 수를 알아내는 메소드를 실행
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (map[i][j] == 1) {
                    count = 0;
                    find(i, j, N);
                    dangi.add(count);
                }
            }
        }

        dangi.sort(Comparator.naturalOrder());
        sb.append(dangi.size() + "\n");
        for (int data : dangi) {
            sb.append(data + "\n");
        }
        System.out.println(sb);
    }

    static void find(int x, int y, int n) {
        if (x < 0 || y < 0 || x >= n || y >= n || map[x][y] == 0) {
            return;
        }

        map[x][y] = 0;
        count++;

        find(x-1, y, n);
        find(x+1, y, n);
        find(x, y+1, n);
        find(x, y-1, n);
    }
}
