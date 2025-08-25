package class3.sliver;

import java.io.IOException;

/**
 * 하얀색 0
 * 파란색 1
 */
public class Q2630 {
    static int blue = 0;
    static int white = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = read();

        paper = new int[N][N];
        for (int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                paper[i][j] = read();
            }
        }

        isSquare(0, 0, N);
        sb.append(white + "\n").append(blue);
        System.out.println(sb);
    }

    static void isSquare(int iNum, int jNum, int n) {
        // 해당 방식으로 변경되는 즉시 반환하는 방법이 더 좋다
//        int color = paper[x][y];
//        for (int i = x; i < x + n; i++) {
//            for (int j = y; j < y + n; j++) {
//                if (paper[i][j] != color) {
//                    return false;
//                }
//            }
//        }
        int isSeq = 0;
        for (int i=iNum; i<(iNum+n); i++) {
            for(int j=jNum; j<(jNum+n); j++) {
                isSeq += paper[i][j];
            }
        }

        if (isSeq == 0) {
            white++;
            return;
        } else if (isSeq == n*n) {
            blue++;
            return;
        } else {
            isSquare(iNum, jNum, n/2);
            isSquare(iNum, jNum+n/2, n/2);
            isSquare(iNum+n/2, jNum, n/2);
            isSquare(iNum+n/2, jNum+n/2, n/2);
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
