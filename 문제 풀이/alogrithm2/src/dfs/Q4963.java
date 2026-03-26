package dfs;

import java.io.*;
import java.util.*;

public class Q4963 {
    static int[][] map;
    static int width;
    static int height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 0 < w, h <= 50
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            
            if (width == 0 && height ==0) {
                break;
            }


            map = new int[height][width];
            for (int i=0; i<height; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<width; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<height; i++) {
                for (int j=0; j<width; j++) {
                    if (map[i][j] == 1) {
                        count++;
                        map[i][j] = 0;
                        dfs(j, i);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
    }
    
    static void dfs(int n, int m) {
        for (int i=-1; i<2; i++) {
            for (int j=-1; j<2; j++) {
                int x = (n + j);
                int y = (m + i);
                if (x < 0 || x >= width || y < 0 || y >= height) {
                    continue;
                }

                if (map[y][x] == 1) {
                    map[y][x] = 0;
                    dfs(x, y);
                }
            }
        }
    }
}