package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q10816 {
    /**
     * 1. 둘째줄은 가지고 있는 숫자 카드
     * 2. 넷째줄은 가져야 될 카드
     */

    private static int[] array = new int[20000001];
    /**
     * by counting array
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++) {
            array[Integer.parseInt(st.nextToken()) + 10000000] += 1;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<M; i++) {
            int data = Integer.parseInt(st.nextToken()) +  + 10000000;
            sb.append(array[data]+ " ");
        }

        System.out.println(sb);
    }

    /**
     * by hashmap
     * @throws IOException
     */
    public static void find1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        String[] Ndata = br.readLine().split(" ");

        int M = Integer.parseInt(br.readLine());
        String[] Mdata = br.readLine().split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String data : Mdata) {
            map.put(data, 0);
        }

        for (String data : Ndata) {
            if (map.containsKey(data)) {
                map.put(data, map.get(data)+1);
            }
        }

        for (String data : Mdata) {
            sb.append(map.get(data)+ " ");
        }

        System.out.println(sb);
    }
}
