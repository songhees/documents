package programmers.hash;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 가장 많은 종류의 포켓몬을 선택하는 방법
 * 종류 번호의 개수
 */
public class Hash2 {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2, 3};
        int name = solution(nums);

        System.out.println(name);
    }

    static int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return Math.min(set.size(), nums.length / 2);
    }
}
