package class3.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11723 {
    /**
     * 카운팅 정렬을 이용
     * @param args
     * @throws IOException
     */
    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        int[] array = new int[21];

        StringTokenizer st;
        for (int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "add" : {
                    int data = Integer.parseInt(st.nextToken());
                    array[data] = 1;
                    break;
                }
                case "remove" : {
                    int data = Integer.parseInt(st.nextToken());
                    array[data] = 0;
                    break;
                }
                case "check" : {
                    int data = Integer.parseInt(st.nextToken());
                    sb.append((array[data] == 1 ? 1 : 0) + "\n");
                    break;
                }
                case "toggle" : {
                    int data = Integer.parseInt(st.nextToken());
                    array[data] = (array[data] == 1) ? 0 : 1;
                    break;
                }
                case "all" : {
                    for(int j=0; j<21; j++) {
                        array[j] = 1;
                    }
                    break;
                }
                case "empty" : {
                    for(int j=1; j<21; j++) { array[j] = 0; }
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    /**
     * 비트연산
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        int bit = 0;
        StringTokenizer st;
        for (int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "add" : {
                    int data = Integer.parseInt(st.nextToken());

                    bit |= (1 << (data-1));
                    break;
                }
                case "remove" : {
                    int data = Integer.parseInt(st.nextToken());
                    bit = bit & ~(1 << (data-1));
                    break;
                }
                case "check" : {
                    int data = Integer.parseInt(st.nextToken());

                    if ((bit & (1 << (data- 1))) != 0) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                }
                case "toggle" : {
                    int data = Integer.parseInt(st.nextToken());
                    bit = bit ^ (1 << (data-1));
                    break;
                }
                case "all" : {
                    // 21 bit 10000 00000000 00000000 -1
                    // 을 하여 1111 11111111 11111111 을 만듬
                    bit = (1<<20) - 1;
                    break;
                }
                case "empty" : {
                    bit = 0;
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
