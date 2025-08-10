package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1018 {
    /**
     * 1. M*N 정사각형의 보드
     * 2. 8*8 크기의 체스판 만들기
     * 3. 다시 칠해야되는 정사각형의 개수
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
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
        int rowRange = 0; //  0 ~ 2 = 10 - 8 = rowNum - 8
        int colRange = 0; //  0 ~ 5 = 13 - 8 = colNum - 8
        // 패턴
        int min = 64;
        while (true) {
            int count = 0;
            for (int i=rowRange; i<rowRange+8; i++) {
                String[] row = array[i];
                if (i%2 == 0) {
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
                } else {
                    for(int j=0; j<4; j++) {
                        if (!"B".equals(row[colRange + 2*j])) {
                            count++;
                        }
                    }
                    // 홀수
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

            if (colRange > colNum - 8) {
                colRange = 0;
                rowRange++;
            }

            if (rowRange > rowNum - 8) {
                break;
            }
        }

        System.out.println(min);
    }
}
