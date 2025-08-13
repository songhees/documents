package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        int cIndex = (num+1)/2;

        double total = 0;
        int[] freq = new int[8001];
        for(int i=0; i<num; i++) {
            int data =  Integer.parseInt(br.readLine());
            total += data;
            freq[data+4000] += 1;
        }

        int max = 0;
        int index = 0;
        // 몇번째로 작은값인가?
        int count = 0;
        // 중앙값
        int center = 0;
        // 처음
        int first = 0;
        // 끝
        int last = 0;
        int isData = 0;
        for(int i=0; i<8001; i++) {
            if (freq[i] > 0) {
                // 처음 들어온 값
                if (isData == 0) {
                    first = i;
                }
                // 중앙값 찾기
                if (cIndex > 0) {
                    cIndex -= freq[i];
                    if (cIndex <= 0) {
                        center = i-4000;
                    }
                }

                isData += freq[i];
                // 마지막 값
                if (isData == num) {
                    last = i;
                }
            }

            if (max < freq[i]) {
                max = freq[i];
                index = i-4000;
                count = 0;
            } else if (max == freq[i]) {
                if (++count == 1) {
                    index = i-4000;
                }
            }
        }

        sb.append(Math.round(total/num)+"\n");
        sb.append(center+"\n");
        sb.append(index+"\n");
        sb.append((last - first)+"\n");
        System.out.println(sb);
    }
}
