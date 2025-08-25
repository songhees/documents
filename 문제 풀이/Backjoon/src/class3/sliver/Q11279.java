package class3.sliver;

import java.io.IOException;

/**
 * 1 <= N 연산수 <= 100 000
 * 0 일때 가장 큰 수를 출력 후 제거
 */
public class Q11279 {
    static class MaxQueue {
        // 그 다음 넣을 수 있는 index 위치
        int index;
        int[] que;

        public MaxQueue (int capacity) {
            que = new int[capacity];
            index = 0;
        }

        public void add(int data) {
            if (index >= que.length) {
                return;
            }

            que[index] = data;
            addMove(index++);
        }

        public void addMove(int idx) {
            if (idx <= 0) {
                return;
            }
            int pt = (idx-1)/2;

            if (que[pt] < que[idx]) {
                swap(idx, pt);
                addMove(pt);
            }
        }

        public int poll() {
            if (index <= 0) {
                return 0;
            }

            int result = que[0];
            index--;
            pollMove();

            return result;
        }
        public void pollMove() {
            que[0] = que[index];

            int idx = 0;
            while (idx < index) {
                int left = idx*2 + 1;
                int right = idx*2 + 2;
                int maxIdx = idx;

                if (left < index && que[left] > que[maxIdx]) {
                    maxIdx = left;
                }
                if (right < index && que[right] > que[maxIdx]) {
                    maxIdx = right;
                }

                if (idx == maxIdx) {
                    break;
                }
                swap(idx, maxIdx);
                idx = maxIdx;
            }
        }

        void swap(int idx, int pt) {
            int temp = que[pt];

            que[pt] = que[idx];
            que[idx] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = read();

        MaxQueue que = new MaxQueue(100000);
        for (int i=0; i<N; i++) {
            int data = read();
            if (data == 0) {
                sb.append(que.poll() + "\n");
            } else {
                que.add(data);
            }
        }
        System.out.println(sb);
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
