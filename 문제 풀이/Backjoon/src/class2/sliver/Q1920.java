package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1920 {
    /**
     * 1. 4번째 줄의 숫자가 2번째 줄의 숫자에 존재하는지 여부
     * 2. 존재 = 1, 존재하지 않음 = 0
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Map<String, String> map = new HashMap<>();
        for(int i=0; i<num; i++) {
            String data = st.nextToken();
            if (map.get(data) == null) {
                map.put(data, "1");
            }
        }

        int num1 = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<num1; i++) {
            sb.append(map.get(st.nextToken()) != null ? "1" : "0").append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
