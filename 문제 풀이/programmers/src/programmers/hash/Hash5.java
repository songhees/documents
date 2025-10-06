package programmers.hash;


import java.util.*;

/**
 * 장르 별로 가장 많이 재생된 노래를 두개씩 모아
 *
 *
 * 가장 많이 재생된 장르에 포함된 노래먼저 수록
 * 장르 내에서 가장 많이 재생된 노래 수록
 * 고유번호가 낮은 노래 먼저 수록
 */
public class Hash5 {
    public static void main(String[] args) {

        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};
        int[] name = solution(genres, plays);

        System.out.println(Arrays.toString(name));
    }

    static int[] solution(String[] genres, int[] plays) {
        int length = genres.length;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        TreeMap<Integer, ArrayList<int[]>> data = new TreeMap<>(Comparator.reverseOrder());
        for (int i=0; i<length; i++) {
            int total = map.get(genres[i]);

            ArrayList<int[]> list;
            if (data.get(total) == null) {
                list = new ArrayList<>();
            } else {
                list = data.get(total);
            }
            list.add(new int[]{i, plays[i]});
            data.put(total, list);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int key : data.keySet()) {
            ArrayList<int[]> value = data.get(key);
            value.sort((o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o2[1] - o1[0];
                } else {
                    return o2[1] - o1[1];
                }
            });

            result.add(data.get(key).get(0)[0]);
            if (value.size() >= 2) {
                result.add(data.get(key).get(1)[0]);
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
