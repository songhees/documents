package practice6;

import java.util.Scanner;

public class Q3 {
    static void bubbleSort(int[] a, int n) {
        // 첫 for문은 교환되어야될 요소의 개수
        int k = 0;
        int count = 0;
        for(int i=0; i<n-1; i++) {
            i = i < k ? k : i;
            // 교환이 이뤄지는 횟수
            for(int j=n-1; j>i; j--) {
                if (a[j-1] > a[j]) {
                    swap(a, j-1, j);
                    k = j;
                }
                count++;
            }
        }

        System.out.println("횟수 : " + count);
    }

    static void buble(int[] a, int n) {
        int k = 0;
        int count = 0;
        while(k<n-1) {
            int last = n-1;
            for(int j=n-1; j>k; j--) {
                if (a[j-1] > a[j]) {
                    swap(a, j-1, j);
                    last = j;
                }
                count++;
            }
            k = last;
        }
        System.out.println("횟수 : " + count);
    }

    static void swap(int[] a, int before, int after) {
        int temp = a[before];
        a[before] = a[after];
        a[after] = temp;
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

        buble(a, n);

        for(int i=0; i<n; i++) {
            System.out.printf("%2d", a[i]);
        }
    }

}
