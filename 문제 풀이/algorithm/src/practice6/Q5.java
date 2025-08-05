package practice6;

import java.util.Scanner;

public class Q5 {
    static void swap(int[] a, int before, int after) {
        int temp = a[before];
        a[before] = a[after];
        a[after] = temp;
    }
    static void bubbleSort(int[] a, int n) {
        // 첫 for문은 교환되어야될 요소의 개수
        int count = 0;
        int left = 0;
        int right = n-1;
        int last = 0;
        while (left < right) {
            for (int j = left; j < right; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    last = j;
                }
            }
            right = last;
            for (int j = right; j > left; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                }
                count++;
            }
            left = last;
        }
        System.out.println("횟수 : " + count);
    }

    public static void result() {
        Scanner scan = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int n = scan.nextInt();
        int[] a = new int[n];

        for(int i=0; i<n; i++) {
            System.out.print("숫자 입력 : ");
            a[i] = scan.nextInt();
        }

        bubbleSort(a, n);

        for(int i=0; i<n; i++) {
            System.out.printf("%2d", a[i]);
        }
    }
}
