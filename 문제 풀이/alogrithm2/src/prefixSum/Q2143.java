package prefixSum;

import java.io.IOException;
import java.util.Arrays;

public class Q2143 {
    

    public static void main(String[] args) throws IOException {
        int T = readNumber();

        int n = readNumber();
        int[] A = readArray(n);
        int m = readNumber();
        int[] B = readArray(m);

        int[] countA = new int[n*(n+1)/2];
        int[] countB = new int[m*(m+1)/2];

        int indexA = 0;
        // O(N^2)
        for (int i = 0; i < n; i++) {
            countA[indexA++] = A[i];
            for (int j = i+1; j < n; j++) {
                countA[indexA++] = A[j] - A[i];
            }
        }
        int indexB = 0;
        // O(M^2)
        for(int i = 0; i < m; i++) {
            countB[indexB++] = B[i];
            for (int j = i+1; j < m; j++) {
                countB[indexB++] = B[j] - B[i];
            }
        }

        Arrays.sort(countA);
        Arrays.sort(countB);

        long count = 0;
        
        int start = 0;
        int end = countB.length - 1;
        while (start < countA.length && end >= 0) {
            int sum = countA[start] + countB[end];
            if (sum == T) {
                count++;
                // 같은 값이 여러개 있을 수 있기 때문에, 같은 값이 나올 때까지 start와 end를 이동시켜준다.
            } else if (sum < T) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(count);
    }

    public static int readNumber() throws IOException {
        int c;
        while ((c = System.in.read()) <= 32) {
        }

        boolean isNegative = (c == '-');
        if (isNegative) {
            c = System.in.read();
        }

        int num = c & 15;
        while ((c = System.in.read()) > 32) {
            num = (num << 3) + (num << 1) + (c & 15);
        }
        
        return isNegative ? -num : num;
    }

    static int[] readArray(int total) throws IOException {
        int[] arry = new int[total];

        arry[0] = readNumber();
        for (int i = 1; i < total; i++) {
            arry[i] = readNumber() + arry[i - 1];
        }
        return arry;
    }
}

