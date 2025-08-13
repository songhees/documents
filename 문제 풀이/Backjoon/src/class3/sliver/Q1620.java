package class3.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 포켓몬 개수 N 문제 개수 M
 * 1 <= N, M <= 100 000
 * 2 <= 포켓몬 이름 길이 <= 20
 * 1 <= 포켓몬 숫자 <= N
 *
 * 문제  알파벳 = 포켓몬 번호 // 숫자 = 포켓몬 이름
 *
 */
public class Q1620 {
    /**
     * 이름 검색용 숫자 검색용 따로 생성하여 풀이
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] poket = new String[N];
        Map<String, Integer> poketName = new HashMap<>();

        for(int i=0; i<N; i++) {
            String name = br.readLine();
            poket[i] = name;
            poketName.put(name, i+1);
        }

        String regExp = "^[0-9]+$";
        for(int i=0; i<M; i++) {
            String Q = br.readLine();

            if (Q.matches(regExp)) {
                sb.append(poket[Integer.parseInt(Q)-1] + "\n");
            } else {
                sb.append(poketName.get(Q) + "\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
