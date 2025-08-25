package class3.sliver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 1 <= 과일의 종류 <= 9
 * 두종류의 과일
 * 1 <= N <= 200 000 과일 개수
 * 꽂힌 과일 종류
 * 앞 뒤 과일을 제거해서 가장많은 과일을 남겨라
 */

//5
//5 1 1 2 1
public class Q30804 {
    public static void main(String[] args) throws IOException {
        int N = read();

        int[] array = new int[N];
        int max = 0;
        int left = 0;
        int right = 0;
        int type1 = 0;
        int type2 = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i=0; i<N; i++) {
            int data = read();
            array[right] = data;
            count.put(data, count.get(data) == null ? 1 : count.get(data)+1);

            // 과일의 종류가 2가지를 초과
            if (data != type1 && data != type2 && type1 != 0 && type2 != 0) {
                // 그전 종류의 갯수를 세기
                if (max < right-left) {
                    max = (right-left);
                }

                // left를 옮기면서 숫자를 삭제
                // 가장 먼저 삭제되는 수가 버릴 수
                while (left < right) {
                    int j = left++;
                    count.put(array[j], count.get(array[j])-1);

                    if (count.get(array[j]) == 0) {
                        count.remove(array[j]);

                        if (type1 == array[j]) {
                            type1 = data;
                        }
                        if (type2 == array[j]) {
                            type2 = data;
                        }
                        break;
                    }
                }
            } else if (type1 == 0) {
                type1 = data;
            } else if (type1 != data && type2 == 0) {
                type2 = data;
            }
            right++;
        }
        System.out.println(max < (right - left) ? (right - left) : max);
    }

    static int read() throws IOException {
        int num = System.in.read() & 15;
        int input;
        while((input = System.in.read()) > 32) {
            num = (num << 3) + (num << 1) + (input & 15);
        }
        return num;
    }
}
