package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2164 {
    /**
     * 1. 1 ~ N 번 카드가 있다.
     * 2. 맨위에 있는 카드를
     *    홀수번째는 카드를 버리고 짝수번째는 카드를 제일 아래로 옮긴다.
     * 3. 가장 마지막에 존재하는 카드는?
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(num == 1 ? 1 : findLast1(num));
    }

    public static int findLast1(int num) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=num; i++) {
                queue.add(i);
        }
        int count = 1;
        int total = 2*num-3;
        while(count <= total) {
            if (count%2 == 1) {
                queue.remove();
            } else {
                int no = queue.remove();
                queue.add(no);
            }
            count++;
        }
        return queue.remove();
    }

    public static int findLast(int num) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<num/2; i++) {
            if (num%2 == 0) {
                queue.add(i == 0 ? num : i*2);
            } else {
                queue.add((i+1)*2);
            }
        }

        int count = 1;
        int total = 2*(num/2 - 1);
        while(count <= total) {
            if (count%2 == 1) {
                int no = queue.remove();
                queue.add(no);
            } else {
                queue.remove();
            }
            count++;
        }

        return queue.remove();
    }
}
