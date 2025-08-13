package class2.sliver;

import java.io.IOException;

public class Q1929 {
    /**
     * 소수 구하기
     * 에라토스테네스의 체
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        int start = read();
        int end = read();

        // 소수면 = false 소수가 아니면 = true
        boolean[] data = new boolean[end+1];
        // 소수 여부를 판단하기 위해서
        // 제일 끝의 수의 제곱근보다 작은 약수의 배수를 갖지 않으면됨

        data[0] = true;
        data[1] = true;

        for(int i=2; i*i <= end; i++) {
            if (!data[i]) {
                // i(소수)의 배수인 수를 true(소수가 아님) 로 변경
                for(int j=i+i; j<=end; j+=i) {
                    data[j] = true;
                }
            }
        }

        for (int i=start; i<=end; i++) {
            if (!data[i]) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int num = System.in.read() & 15;
        int input;
        while ((input = System.in.read()) > 32) {
            num = (num << 3) + (num << 1) + (input & 15);
        }
        return num;
    }

    public static void answer1() throws IOException {
        StringBuffer sb = new StringBuffer();
        int start = read();
        int end = read();

        int index = 0;
        int[] data = new int[1000000];


        int findIndex = 0;
        for (int i=2; i<=end; i++) {
            if (i == start) {
                findIndex = index;
            }

            if (i == 2) {
                data[index++] = 2;
                continue;
            }
            if (i == 3) {
                data[index++] = 3;
                continue;
            }

            boolean valid = true;
            for(int j=0; data[j]*data[j] <= i; j++) {
                if (i%data[j] == 0) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                data[index++] = i;
            }
        }

        for(int i=findIndex; i<index; i++) {
            sb.append(data[i] + "\n");
        }

        System.out.println(sb);
    }
}
