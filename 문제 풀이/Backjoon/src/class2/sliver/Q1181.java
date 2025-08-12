package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 단어 정렬
 * 1. 길이가 짧은것
 * 2. 길이가 같으면 사전순으로
 * 3. 중복 없애기
 */
public class Q1181 {
    /**
     * 중복을 없애는것을 표출할때 없애기
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        String[] node = new String[num];
        for (int i=0; i<num; i++) {
            node[i] = br.readLine();
        }

        // 중요
        Arrays.sort(node, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        // 중요
        for (int i=0; i<num; i++) {
            if (i == num-1 || !node[i].equals(node[i+1])) {
                System.out.println(node[i]);
            }
        }

        br.close();
    }

    public static void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        List<String>[] node = new ArrayList[50];

        for (int i=0; i<num; i++) {
            String data = br.readLine();

            if (node[data.length()-1] == null) {
                node[data.length()-1] = new ArrayList<>();
            }

            if (node[data.length()-1].indexOf(data) == -1) {
                node[data.length()-1].add(data);
            }
        }

        for (int i=0; i<50; i++) {
            if (node[i] != null) {
                node[i].sort(Comparator.naturalOrder());
            }
        }

        for (int i=0; i<50; i++) {
            if (node[i] != null) {
                node[i].stream().forEach(data -> System.out.println(data));
            }
        }
        br.close();
    }

    public static void answer1 () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i=0; i<num; i++) {
            String data = br.readLine();

            // 여기에서 시간이 많이 소요...
            if (list != null && list.indexOf(data) == -1) {
                list.add(data);
            }
        }

        list.sort((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return o1.compareTo(o2);
            }
        });

        list.stream().forEach(data -> System.out.println(data));

        br.close();
    }
}
