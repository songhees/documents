package programmers.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class Hash1 {
    public static void main(String[] args) {

        String[] partocipant = new String[]{"kiki","leo", "eden"};
        String[] completion = new String[]{"eden", "kiki"};
        String name = solution(partocipant, completion);

        System.out.println(name);
    }

    static String solution1(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String par : participant) {
            map.put(par, map.getOrDefault(par, 0) + 1);
        }

        for (String com : completion) {
            map.put(com, map.get(com)-1);
        }


        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }

    static String solution(String[] participant, String[] completion) {
        List<String> list = new ArrayList<>(List.of(participant));
        for (String s : completion) {
            list.remove(s);
        }
        return list.getFirst();
    }
}
