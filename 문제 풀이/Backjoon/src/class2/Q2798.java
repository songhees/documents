package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2798 {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        int[] datas = new int[num];

        for(int i=0; i<num; i++) {
            datas[i] = Integer.parseInt(st.nextToken());
        }

        int result = find2(num, target, datas);

        System.out.println(result);
    }

    public static int find(int num, int target, int[] data) {
        int result = 0;

        for(int i=0; i<num-2; i++) {
            for (int j=i+1; j<num-1; j++) {
                for(int z=j+1; z<num; z++) {

                    int total = data[i] + data[j] + data[z];

                    if (total == target) {
                        return target;
                    } else if ( target-total > 0 && (target-result) > (target-total) ) {
                        result = total;
                    } else {
                        continue;
                    }
                }
            }
        }
        return result;
    }

    public static int find2(int num, int target, int[] data) {
        int result = 0;

        Arrays.sort(data);

        for (int i = 0; i < num - 2; i++) {
            int left = i + 1;
            int right = num - 1;

            while (left < right) {
                int sum = data[i] + data[left] + data[right];

                if (sum == target) {
                    result = sum;
                    return result;
                }

                if (sum < target) {
                    // 합이 M보다 작으므로, 더 큰 합을 위해 left를 증가
                    result = Math.max(result, sum);
                    left++;
                } else {
                    // 합이 M보다 크므로, 더 작은 합을 위해 right를 감소
                    right--;
                }
            }
        }
        return result;
    }
}
