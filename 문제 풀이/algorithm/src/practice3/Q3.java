package practice3;

import java.util.Scanner;

public class Q3 {

    public static void result() {
        Scanner scan = new Scanner(System.in);
        int n;
        do {
            System.out.print("요솟수 입력: ");
            n = scan.nextInt();
        } while(n < 1);

        int[] a = new int[n];
        int[] idx = new int[n];

        for(int i = 0; i < n; i++) {
            System.out.print((i+1) + "번째 요소 입력: ");
            a[i] = scan.nextInt();
        }

        System.out.print("찾을 숫자 입력: ");
        int key = scan.nextInt();
        searchIdx(a, n, key, idx);

    }

    static void searchIdx(int[] a, int n, int key, int[] idx) {
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                idx[index++] = i;
            }
        }
        System.out.println("발견한 개수 : " + index);
    }
}
