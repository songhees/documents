package programmers.hash;

import java.util.Arrays;

/**
 * 앞의 번호가 같은 경우
 *
 *
 */
public class Hash3 {
    public static void main(String[] args) {

        String[] nums = new String[]{"123","456","789"};
        boolean name = solution(nums);

        System.out.println(name);
    }

    static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i=0; i<phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
