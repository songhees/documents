package twoPointer;

import java.io.*;
import java.util.*;

// N M = CD 수 (1,000,000)
// 두 사람이 가지고 있는 같은 CD의 수
public class Q4158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int n = 0;
        int m = 0;
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }
            int[] nArray = new int[n];
            int[] mArray = new int[m];
            for (int i=0; i<n; i++) {
                nArray[i] = Integer.parseInt(br.readLine());
            }
            for (int i=0; i<m; i++) {
                mArray[i] = Integer.parseInt(br.readLine());
            }

            int nIndex = 0;
            int mIndex = 0;
            int count = 0;
            while(nIndex < n && mIndex < m) {    
                if (nArray[nIndex] == mArray[mIndex]) {
                    count++;
                    nIndex++;
                    mIndex++;
                } else if (nArray[nIndex] < mArray[mIndex]) {
                    nIndex++;
                } else {
                    mIndex++;
                }
            }

            sb.append(count).append('\n');
        }

        System.out.println(sb.toString());
    }
}
