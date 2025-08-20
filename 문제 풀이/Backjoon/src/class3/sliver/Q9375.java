package class3.sliver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 0 <= 의상의 수 = 최대 종류의 수 <= 30
 */
public class Q9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {
            int M = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            for(int j=0; j<M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String sort = st.nextToken();
                sort = st.nextToken();

                if (map.get(sort) == null) {
                    map.put(sort, 1);
                } else {
                    map.put(sort, map.get(sort)+1);
                }
            }


            int result = 1;
            for (int data : map.values()) {
                result *= (data+1);
            }
            sb.append((result-1) + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
