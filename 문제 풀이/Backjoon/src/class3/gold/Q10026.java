package class3.gold;

import java.io.*;

/**
 * R, G, B : 구역의 수
 * R+G, B : 구역의 수
 */
public class Q10026 {
    static int N;
    static final int[] DX = {0, 0, 1, -1};
    static final int[] DY = {1, -1, 0, 0};
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();

        N = Integer.parseInt(br.readLine());
        String[][] map = new String[N][N];
        String[][] mapGB = new String[N][N];

        for (int i=0; i<N; i++) {
            String[] array = br.readLine().split("");
            for (int j=0; j<N; j++) {
                map[i][j] = array[j];
                mapGB[i][j] = "R".equals(array[j]) ? "G" : array[j];
            }
        }

        int count = 0;
        int countGB = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!"0".equals(map[i][j])) {
                    find(i, j, map);
                    count++;
                }
                if (!"0".equals(mapGB[i][j])) {
                    find(i, j, mapGB);
                    countGB++;
                }
            }
        }
        sb.append(count).append(" ").append(countGB);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void find(int x, int y, String[][] map) {
        String target = map[x][y];
        map[x][y] = "0";

        for (int i=0; i<4; i++) {
            int nextX = x + DX[i];
            int nextY = y + DY[i];

            if (nextX >= N || nextY >= N || nextX < 0 || nextY <0) {
                continue;
            }

            if (target.equals(map[nextX][nextY])) {
                find(nextX, nextY, map);
            }
        }
    }
}
