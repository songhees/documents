package simulation.sliver;

import java.io.*;
import java.util.*;

public class Q2578 {
    static int[][] board = new int[25][25];
    static int bingo = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] nums = new int[25][25];
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<5; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 1;
        result : for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                int num = nums[i][j];
                check(num);
                if (bingo >= 3) {
                    break result;
                }
                count++;
            }
        }
        System.out.print(count);
    }

    static void check(int num) {
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (board[i][j] == num) {
                    board[i][j] = 0;
                    bingGO(i, j);
                }
            }
        }
    }

    static int[][] dx = new int[][]{{-1, 1}, {0, 0}, {-1, 1}, {-1, 1}};
    static int[][] dy = new int[][]{{0, 0}, {-1, 1}, {-1, 1}, {1, -1}};
    
    static void bingGO(int a, int b) {
        for (int i=0; i<4; i++) {
            int[] ax = dx[i];
            int[] ay = dy[i];

            int bingNum = 1;
            for (int j=0; j<2; j++) {
                int curX = a;
                int curY = b;
                
                while (true) {
                    int nextX = curX + ax[j];
                    int nextY = curY + ay[j];
                    
                    if (nextX < 0 || nextY < 0 || nextX > 4 || nextY > 4 || board[nextX][nextY] != 0) {
                        break;
                    }
                    
                    bingNum++;
                    curX = nextX;
                    curY = nextY;
                }                
            }
            if (bingNum == 5) {
                bingo++;
            }
        }
    }
}
