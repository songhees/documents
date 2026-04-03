package simulation;

import java.io.*;
import java.util.*;

public class Q14502 {
    static int[][] array;
    static List<int[]> virus = new ArrayList<>();
    static int n;
    static int m;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());   

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                if (array[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        makedWall(0);

        System.out.print(result);
    }

    static void makedWall(int count) {
        if (count == 3) {
            counting();
            return;
        }

        for (int i=0; i< n; i++) {
            for (int j=0; j<m; j++) {
                if (array[i][j] == 0) {
                    array[i][j] = 1;
                    makedWall(count+1);
                    array[i][j] = 0;
                }
            }
        }
    }

    static void counting() {
        int[][] cloneMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            cloneMap[i] = array[i].clone();
        }

        for (int[] vir : virus) {
            // 시작 값
            runVirus(vir[0], vir[1], cloneMap);
        }

        int count = 0;
        for (int i=0; i< n; i++) {
            for (int j=0; j<m; j++) {
                if (cloneMap[i][j] == 0) {
                    count++;
                }
            }
        }
        result = Math.max(result, count);
    }

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static void runVirus(int y, int x, int[][] map) {        
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < m && nx >= 0 && ny < n && ny >= 0) {
                if (map[ny][nx] == 0) {
                    map[ny][nx] = 2;
                    runVirus(ny, nx, map);
                }
            }
        }
    }
}
