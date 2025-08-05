package practice3;

import java.util.Scanner;

public class Q5 {
    public static void result() {
        Scanner scan = new Scanner(System.in);
        int n;
        do {
            System.out.print("요솟수 입력: ");
            n = scan.nextInt();
        } while(n < 1);

        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            System.out.print((i+1) + "번째 요소 입력: ");
            a[i] = scan.nextInt();
        }

        System.out.print("찾을 숫자 입력: ");
        int key = scan.nextInt();

        binSearchX(a, n, key);
    }

    static void binSearchX(int[] a, int n, int key) {
        int index = 0;

        int start = 0;
        int end = n-1;

        do {
            int mid = (start + end)/2;

            if (a[mid] == key) {
                index = mid;
                break;
            } else if (a[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } while(start <= end);

        for(int i=(index-1); i > 0; i--) {
            if (a[i] == key) {
                index = i;
            } else {
                break;
            }
        }

        System.out.println("가장 앞의 인덱스 : " + index);
    }
}
