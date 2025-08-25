package class3.sliver;

import java.io.*;

/**
 * 1 <= N <= 600 1 <= M <= 600
 * P는 도착점
 * I는 출발점
 * X는 못감
 */
public class Q21736 {
    static Character[][] camp;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = readNumber();
        int M = readNumber();
        camp = new Character[N][M];

        int x = 0;
        int y = 0;
        // 데이터 넣기
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                camp[i][j] = (char)System.in.read();
                if (camp[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
            read();
        }

        findP(x, y, N, M);

        bw.write(String.valueOf(count == 0 ? "TT" : count));
        bw.flush();
        bw.close();
    }

    static void findP(int x, int y, int N, int M) {
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return;
        }

        switch (camp[x][y]) {
            case 'O' :
            case 'I' : {
                camp[x][y] = 'X';
                findP(x+1, y, N, M);
                findP(x-1, y, N, M);
                findP(x, y+1, N, M);
                findP(x, y-1, N, M);
                break;
            }
            case 'X' : {
                break;
            }
            case 'P' : {
                count++;
                camp[x][y] = 'X';
                findP(x+1, y, N, M);
                findP(x-1, y, N, M);
                findP(x, y+1, N, M);
                findP(x, y-1, N, M);
                break;
            }
        }
    }

    static void read() throws IOException {
        int c;
        while((c = System.in.read()) > 31) {

        }
    }

    static int readNumber() throws IOException {
        int number = 0;
        int c;
        while ((c = System.in.read()) > 32) { // 32는 공백의 아스키 코드
            number = 10 * number + (c - 48); // 문자를 숫자로 변환
        }
        return number;
    }
}
