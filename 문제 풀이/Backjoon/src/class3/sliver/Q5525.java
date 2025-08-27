package class3.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * I와 O로만 이뤄진 문자열 과 정수 N이 주어짐
 * 문자열안에 IOIO..이 몇군데 포함되어 있는가?
 *
 * N 이 1이라면 P1은 IOI
 * 2라면 P2 IOIOI
 */
public class Q5525 {
    /**
     * 정석풀이 / 직관적 공간복잡도 가 더 낮음
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // PN의 N
        int M = Integer.parseInt(br.readLine()); // 문자열 길이
        String S = br.readLine();

        int answer = 0;
        int cnt = 0;

        for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                cnt++;
                if (cnt == N) {
                    answer++;
                    cnt--; // 겹치는 경우 고려
                }
                i++; // "IOI" 패턴 마지막 I까지 건너뜀
            } else {
                cnt = 0;
            }
        }

        System.out.println(answer);
    }

    /**
     * 내풀이
     * @param args
     * @throws IOException
     */
    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());
        String txt = br.readLine();

        // S에서 IOIOIOI 형식의 길이가 몇인지 몇개 있는지 부터 확인
        List<Integer> IOI = new ArrayList<>();
        int start = txt.indexOf("IOI");
        int end = start+2;
        while (start != -1) {
            int index = txt.indexOf("IOI", end);

            if (index != end) {
                IOI.add(end-start+1);
                start = index;
            }
            end = index + 2;
        }

        int count = 0;
        for(int data : IOI) {
            int max = data/2;
            if (max >= N) {
                count += (max-(N-1));
            }
        }
        System.out.println(count);
    }
}
