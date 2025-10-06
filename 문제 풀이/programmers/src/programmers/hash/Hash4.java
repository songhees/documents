package programmers.hash;

import java.util.HashMap;

public class Hash4 {
    public static void main(String[] args) {

        String[][] nums = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int name = solution(nums);

        System.out.println(name);
    }

    static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 1) + 1);
        }

        for (int value : map.values()) {
            answer *= value;
        }
        return answer-1;
    }
}
