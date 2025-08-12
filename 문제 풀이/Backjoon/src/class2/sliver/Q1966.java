package class2.sliver;

import java.io.IOException;

public class Q1966 {
    /**
     * 원 퀵 정렬
     * 배열이 원으로 존재한다고 가정
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int count = read();

        for(int n=0; n<count; n++) {
            int[] im = new int[9];
            int num = read();

            int target = read();
            int[] array = new int[num];

            for(int i=0; i<num; i++) {
                int data = read();
                im[data-1]++;
                array[i] = data;
            }

            // 인쇄 순서
            int output = 0;
            // 디큐 하는 index
            int front = 0;
            // 인큐 하는 index
            int end = 0;
            while (true) {
                // 중요도가 가장 높은 숫자 인가?
                boolean max = true;
                for(int i=8; i>=0; i--) {
                    if (array[front] < (i+1) && im[i] > 0) {
                        max = false;
                        break;
                    }
                }

                if (max) {
                    // 중요도 목록 데이터 삭제
                    im[array[front]-1]--;
                    output++;
                    // 궁금한 문서 위치
                    if (target == front) {
                        break;
                    }
                } else {
                    // 문서 위치가 옮겨지는 경우
                    if (target == front) {
                        target = end;
                    }
                    // 중요도가 낮은 숫자인 경우 front에서 디큐해서 end에 인큐
                    array[end] = array[front];
                    end++;
                }
                front++;

                // index가 최대 값을 넘을 경우
                if (front > num-1) {
                    front = 0;
                }
                if (end > num-1) {
                    end = 0;
                }
            }

            sb.append(output + "\n");
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
}
