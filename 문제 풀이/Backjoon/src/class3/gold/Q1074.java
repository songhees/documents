package class3.gold;

import java.io.IOException;

/**
 * N 2^N 정사각형에서 r행 c열을 몇번째로 방문하는지 출력
 * r 가로
 * c 세로
 * N = 2 일때 4X4
 * N = 3 일때 8X8
 * 1 <= N <= 15
 *
 * 4분할로 계속 쪼개서 DP 형식으로 계산
 *
 */
public class Q1074 {
    public static void main(String[] args) throws IOException {
        int N = read();
        int r = read(); // 행 가로
        int c = read(); // 열 세로

        int result = find(N, r, c);
        System.out.println(result);
    }

    static int find(int N, int r, int c) {
        if (N < 1 || r < 0 || c < 0) {
            return 0;
        }

        int length = (int) Math.pow(2, N)/2;
        int start = 0;
        if (r/length <= 0 && c/length > 0) {
            start = (int) Math.pow(2, (N-1)*2);
            c -= length;
        } else if (r/length > 0 && c/length <= 0) {
            start = (int) Math.pow(2, (N-1)*2)*2;
            r -= length;
        } else if (r/length > 0 && c/length > 0) {
            start = (int) Math.pow(2, (N-1)*2)*3;
            r -= length;
            c -= length;
        }

        return start + find(N-1, r, c);
    }
    public static void main2(String[] args) throws IOException {
        int N = read();
        int r = read(); // 행 가로
        int c = read(); // 열 세로

        int l = (int) Math.pow(2, N-1);
        int[][] squar = new int[l][l];
        squar[0][0] = 0;

        for (int z = 2; z <= N; z++) {
            int x = (int) Math.pow(2, z-2);
            int y = (int) Math.pow(2, z-2);

            int end = (int) Math.pow(2, z-2);
            int plus = (int) Math.pow(4, z-1);
            // 세로 y
            for (int i=0; i<end; i++) {
                // 가로 x
                for (int j=0; j<end; j++) {
                    squar[i][j+x] = squar[i][j] + plus;
                }
            }

            for (int i=0; i<end; i++) {
                // 가로 x
                for (int j=0; j<end; j++) {
                    squar[i+y][j] = squar[i][j] + plus*2;
                }
            }

            for (int i=0; i<end; i++) {
                // 가로 x
                for (int j=0; j<end; j++) {
                    squar[i+y][j+x] = squar[i][j] + plus*3;
                }
            }
        }

        // 마지막 수
        int data = squar[r/2][c/2];

        if (r%2 != 0 && c%2 != 0) {
            data += 3;
        } else if (c%2 != 0) {
            data += 1;
        } else if (r%2 != 0) {
            data += 2;
        }

        System.out.println(data);
    }

    public static void main1(String[] args) throws IOException {
        int N = read();
        int r = read(); // 행 가로
        int c = read(); // 열 세로

        int l = (int) Math.pow(2, N);
        int[][] squar = new int[l][l];

        int count = 0;
        for (int i=0; i<2; i++) {
            // 가로 x
            for (int j=0; j<2; j++) {
                squar[i][j] = count++;
            }
        }

        for (int z = 2; z <= N; z++) {
            int x = (int) Math.pow(2, z-1);
            int y = (int) Math.pow(2, z-1);

            int end = (int) Math.pow(2, z-1);
            int plus = (int) Math.pow(2, (z-1)*2);
            // 세로 y
            for (int i=0; i<end; i++) {
                // 가로 x
                for (int j=0; j<end; j++) {
                    squar[i][j+x] = squar[i][j] + plus;
                }
            }

            for (int i=0; i<end; i++) {
                // 가로 x
                for (int j=0; j<end; j++) {
                    squar[i+y][j] = squar[i][j] + plus*2;
                }
            }

            for (int i=0; i<end; i++) {
                // 가로 x
                for (int j=0; j<end; j++) {
                    squar[i+y][j+x] = squar[i][j] + plus*3;
                }
            }
        }
        System.out.println(squar[r][c]);
    }

    static int read() throws IOException {
        int num = System.in.read() & 15;
        int input;
        while ((input = System.in.read()) > 32) {
            num = (num << 3) + (num << 1) + (input & 15);
        }
        return num;
    }
}
