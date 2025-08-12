package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. M*N 정사각형의 보드
 * 2. 8*8 크기의 체스판 만들기
 * 3. 다시 칠해야되는 정사각형의 개수
 */
public class Q1018 {
    static String[][] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int rowNum = Integer.parseInt(st.nextToken());
        int colNum = Integer.parseInt(st.nextToken());

        array = new String[rowNum][colNum];

        for(int i=0; i<rowNum; i++) {
            array[i] = br.readLine().split("");
        }

        // 8x8의 최대 값은 64
        int min = 64;
        for(int i=0; i<=(rowNum-8); i++) {
            for(int j=0; j<=(colNum-8); j++) {
                int minOther = minCount(i, j);
                min = Math.min(min, minOther);
            }
        }

        br.close();
        System.out.println(min);
    }

    /**
     * 행과 열의 합을 이용하여 두 가지 체스판 패턴을 동시에 검사
     * @param row
     * @param col
     * @return
     */
    public static int minCount(int row, int col) {
        int countW = 0;
        int countB = 0;

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                String target = array[i+row][j+col];

                if ((i+j)%2 == 0) {
                    if (!target.equals("W")) {
                        countW++;
                    }
                    if (!target.equals("B")) {
                        countB++;
                    }
                } else {
                    if (!target.equals("B")) {
                        countW++;
                    }
                    if (!target.equals("W")) {
                        countB++;
                    }
                }
            }
        }
        return Math.min(countW, countB);
    }


    /**
     * "WBWBWBWB" 패턴을 이진법으로 변경 후 XOR 계산으로 차이 여부를 판단
     * @throws IOException
     */
    public static void answer2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int rowNum = Integer.parseInt(st.nextToken());
        int colNum = Integer.parseInt(st.nextToken());

        String[] array = new String[rowNum];

        for(int i=0; i<rowNum; i++) {
            array[i] = br.readLine().replace("W", "0").replace("B", "1");
        }

        // W -> 0, B -> 1
        // 0010011
        // 1100110
        int min = 64;

        int rowRange = 0; //  0 ~ 2 = 10 - 8 = rowNum - 8
        int colRange = 0; //  0 ~ 5 = 13 - 8 = colNum - 8
        String black = "10101010";
        String white = "01010101";
        while (true) {
            int countW = 0;
            int countB = 0;
            for (int i=rowRange; i<rowRange+8; i++) {
                String substring = array[i].substring(colRange, colRange + 8);
                if (i%2 == 0) {
                    countW += counting(substring, white);
                    countB += counting(substring, black);
                } else {
                    countW += counting(substring, black);
                    countB += counting(substring, white);
                }
            }

            if (countW > countB && countB < min) {
                min = countB;
            } else if (countW <= countB && countW < min) {
                min = countW;
            }


            colRange++;

            if (colRange > colNum - 8) {
                colRange = 0;
                rowRange++;
            }

            if (rowRange > rowNum - 8) {
                break;
            }
        }

        br.close();
        System.out.println(min);
    }

    public static int counting(String binary, String pattern) {
        int decimal1 = Integer.parseInt(binary, 2);
        int decimal2 = Integer.parseInt(pattern, 2);

        // 2. 십진수 정수에 대해 XOR 연산
        int resultDecimal = decimal1 ^ decimal2;

        // 3. 결과를 다시 이진수 문자열로 변환
        String str = Integer.toBinaryString(resultDecimal);

        String[] arr = str.split("");

        int result = 0;
        for(String ar : arr) {
            result += Integer.parseInt(ar);
        }
        return result;
    }

    public static void answer1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int rowNum = Integer.parseInt(st.nextToken());
        int colNum = Integer.parseInt(st.nextToken());

        String[][] array = new String[rowNum][colNum];

        for(int i=0; i<rowNum; i++) {
            array[i] = br.readLine().split("");
        }

        br.close();

        // 구현
        int rowRange = 0; // 가로 index 범위 0 ~ 2 = 10 - 8 = rowNum - 8
        int colRange = 0; // 세로 index 범위 0 ~ 5 = 13 - 8 = colNum - 8
        // 8X8 보드의 최대 다시 칠하는 횟수는 64
        int min = 64;
        while (true) {
            int count = 0;
            // 세로 8줄 선택
            for (int i=rowRange; i<rowRange+8; i++) {
                String[] row = array[i];
                // 짝수 줄에서 "WBWBWBWB" 패턴
                // 홀수 줄에서 "BWBWBWBW" 패턴인 경우
                if (i%2 == 0) {
                    // 가로 줄에서 짝수 번째
                    for(int j=0; j<4; j++) {
                        if (!"W".equals(row[colRange+ 2*j])) {
                            count++;
                        }
                    }
                    // 가로 줄에서 홀수 번째
                    for(int j=0; j<4; j++) {
                        if (!"B".equals(row[colRange+ (2*j)+1])) {
                            count++;
                        }
                    }
                } else {
                    for(int j=0; j<4; j++) {
                        if (!"B".equals(row[colRange + 2*j])) {
                            count++;
                        }
                    }
                    for(int j=0; j<4; j++) {
                        if (!"W".equals(row[colRange + (2*j)+1])) {
                            count++;
                        }
                    }
                }
            }

            if (min > count) {
                min = count;
            }

            count = 0;
            for (int i=rowRange; i<rowRange+8; i++) {
                String[] row = array[i];
                // 짝수 줄에서 "BWBWBWBW" 패턴
                // 홀수 줄에서 "WBWBWBWB" 패턴인 경우
                if (i%2 == 0) {
                    for(int j=0; j<4; j++) {
                        if (!"B".equals(row[colRange+ 2*j])) {
                            count++;
                        }
                    }
                    // 홀수
                    for(int j=0; j<4; j++) {
                        if (!"W".equals(row[colRange+ (2*j)+1])) {
                            count++;
                        }
                    }
                } else {
                    for(int j=0; j<4; j++) {
                        if (!"W".equals(row[colRange+ 2*j])) {
                            count++;
                        }
                    }
                    // 홀수
                    for(int j=0; j<4; j++) {
                        if (!"B".equals(row[colRange+ (2*j)+1])) {
                            count++;
                        }
                    }
                }
            }

            if (min > count) {
                min = count;
            }

            colRange++;

            // 모든 가로 길이에서 계산이 완료된 경우
            // 그 다음 세로 길이로 넘어감
            if (colRange > colNum - 8) {
                colRange = 0;
                rowRange++;
            }

            // 세로 길이 까지 비교 완료된 경우 계산을 마침.
            if (rowRange > rowNum - 8) {
                break;
            }
        }

        System.out.println(min);
    }
}
