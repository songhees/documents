package class3.sliver;

import java.io.*;
import java.util.*;

/**
 * N개의 수 중에 자기자신보다 작은 수의 개수
 */
public class Q18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] result = new int[N];
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<N; i++) {
            int data = Integer.parseInt(st.nextToken());
            set.add(data);
            result[i] = data;
        }

        List<Integer> array = new ArrayList<>(set);
        array.sort(Comparator.naturalOrder());
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< array.size(); i++) {
            map.put(array.get(i), i);
        }

        for(int i=0; i<N; i++) {
            sb.append(map.get(result[i]) + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
