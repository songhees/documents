package class3.sliver;

import java.io.*;
import java.util.*;

/**
 * 듣도 못한 사람의 수 N
 * 보도 못한 사람의 수 M
 *
 * N 에 해당하는 사람의 이름
 * M 에 해당하는 사람의 이름
 *
 * 1 <= 이름 길이 <= 20
 * 1 <= N. M <= 500 000
 *
 * N, M 의 공통으로 해당된 사람의 수와 이름을 출력
 */
public class Q1764 {
    /**
     * HashSet 을 이용
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> person = new HashSet<>();
        for(int i=0; i<N; i++) {
            person.add(br.readLine());
        }

        String[] same = new String[M];
        for(int i=0; i<M; i++) {
            same[i] = br.readLine();
        }

        Arrays.sort(same, Comparator.naturalOrder());

        int count = 0;
        for(int i=0; i<M; i++) {
            if (person.contains(same[i])) {
                count++;
                sb.append(same[i] + "\n");
            }
        }
        sb.insert(0, count + "\n");

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
