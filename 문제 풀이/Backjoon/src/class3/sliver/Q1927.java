package class3.sliver;

import java.io.IOException;
import java.util.PriorityQueue;

/**
 * 가장 작은 값을 출력하고 값을 제거
 *
 * 1 <= N <= 100 000 N개의 연산정보
 *
 * 0 은 배열에서 가장 작은 값을 출력/제거
 * 나머지는 넣는 값
 *
 */
public class Q1927 {
    static class PriorQueue {
        private int num;
        private int[] que;

        public PriorQueue(int capacity) {
            num = 0;
            que = new int[capacity];
        }

        public void add(int data) {
            if (num >= que.length) {
                return;
            }

            que[num] = data;
            addMove(num++);
        }

        public void addMove(int index) {
            if (index <= 0) {
                return;
            }

            int pt = (index-1)/2;

            if (que[index] < que[pt]) {
                int temp = que[pt];
                que[pt] = que[index];
                que[index] = temp;
                addMove(pt);
            }
        }

        public int poll() {
            if (num <= 0) {
                return 0;
            }
            int data = que[0];
            que[0] = que[--num];
            pollMove(0);

            return data;
        }

        public void pollMove(int index) {
            if (index > num) {
                return;
            }

            while(true) {
                int left = index*2 + 1;
                int right = index*2 + 2;
                int min = index;

                if (left < num && que[min] > que[left]) {
                    min = left;
                }

                if (right < num && que[min] > que[right]) {
                    min = right;
                }

                if (min == index) {
                    break;
                }

                int temp = que[index];
                que[index] = que[min];
                que[min] = temp;

                index = min;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = read();

        PriorQueue minHeap = new PriorQueue(100000);
        for (int i=0; i<N; i++) {
            int data = read();
            if (data == 0) {
                sb.append(minHeap.poll() + "\n");
            } else {
                minHeap.add(data);
            }
        }
        System.out.println(sb);
    }

    public static void main1(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = read();

        PriorityQueue<Integer> minHeap = new PriorityQueue();

        for (int i=0; i<N; i++) {
            int data = read();
            if (data == 0) {
                sb.append((minHeap.isEmpty()  ? 0 : minHeap.poll()) + "\n");

            } else {
                minHeap.add(data);
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
