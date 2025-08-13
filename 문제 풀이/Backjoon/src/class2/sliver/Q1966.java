package class2.sliver;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Q1966 {
    static class Document {
        int index;
        int prio;

        Document(int index, int prio) {
            this.index = index;
            this.prio = prio;
        }

    }

    /**
     * 사용자 정의 클래스와 Queue를 이용한 검색
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int count = read();

        for(int n=0; n<count; n++) {
            // 어떠한 중요도가 몇개 있는지 카운팅 배열로 넣기
            int num = read();

            // 내가 찾아야될 문서의 index 위치
            int target = read();
            // 문서 배열
            Queue<Document> que = new LinkedList<>();

            for(int i=0; i<num; i++) {
                que.add(new Document(i, read()));
            }

            int output = 0;
            while (true) {

                Document current = que.poll();

                boolean isOut = true;
                for(Document doc : que) {
                    if (current.prio < doc.prio) {
                        isOut = false;
                        break;
                    }
                }

                if (isOut) {
                    output++;
                    // 내가 찾는 문서인지 확인
                    if (current.index == target) {
                        break;
                    }
                } else {
                    que.add(current);
                }
            }
            sb.append(output+ "\n");
        }
        System.out.println(sb);
    }
    /**
     * 원 퀵 정렬
     * 1. 배열을 큐 처럼 활용
     * 2. 중요도 존재 여부를 카운팅 배열로 사용
     * @param args
     * @throws IOException
     */
    public static void answer1(String[] args) throws IOException {
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
