package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q12891 {

    // (1 ≤ |P| ≤ |S| ≤ 1,000,000)
    // DNA 문자열 길이 P , 비밀번호로 사용할 문자열 길이 S
    // DNA 문자열
    // {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수
    // 각각의 수는 |S| 보다 작거나 같은 음이 아닌 정수이며 총 합은 |S| 보다 작거나 같음이 보장된다.
    static int idx(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분문자열(윈도우) 길이

        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int[] req = new int[4];
        for (int i = 0; i < 4; i++) req[i] = Integer.parseInt(st.nextToken());

        int[] cur = new int[4];
        int valids = 0;
        for (int i = 0; i < 4; i++) if (req[i] == 0) valids++; // req=0은 처음부터 충족

        // 초기 윈도우 [0, P)
        for (int i = 0; i < P; i++) {
            int x = idx(dna[i]);
            cur[x]++;
            if (cur[x] == req[x]) valids++; // 막 요구치에 도달했을 때만 +1
        }

        int ans = (valids == 4) ? 1 : 0;

        // 슬라이딩
        for (int r = P; r < S; r++) {
            int add = idx(dna[r]);
            cur[add]++;
            if (cur[add] == req[add]) valids++;

            int rem = idx(dna[r - P]);
            if (cur[rem] == req[rem]) valids--; // 빼기 전에 요구치를 딱 채운 상태였다면 이제 미달
            cur[rem]--;

            if (valids == 4) ans++;
        }

        System.out.println(ans);
    }
}
