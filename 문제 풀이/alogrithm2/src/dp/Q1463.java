package dp;

import java.io.*;
import java.util.*;

public class Q1463 {
    static int[] array = new int[1000000+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        dfs(num);

        System.out.print(array[1]);
    }

    static void dfs(int num) {
        if (num <= 0) {
            return;
        }

        if (num%3 == 0 && (array[num%3] == 0 || array[num%3] > array[num] + 1)) {
            array[num/3] = array[num] + 1;
            dfs(num/3);
        }
        if (num%2 == 0 && (array[num%2] == 0 || array[num%2] > array[num] + 1)) {
            array[num/2] = array[num] + 1;
            dfs(num/2);
        }
        if (num-1 > 0 && (array[num-1] == 0 || array[num-1] > array[num] + 1)) {
            array[num-1] = array[num] + 1;
            dfs(num-1);
        }

    }
}
