package class3.sliver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 저장된 사이트 주소의 수 : N
 * 찾으려는 사이트 주소의 수 : M
 *
 * 1 <= N, M <= 100 000
 *
 */
public class Q17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map.put(st.nextToken(), st.nextToken());
        }

        for(int i=0; i<M; i++) {
            bw.write(map.get(br.readLine()) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
