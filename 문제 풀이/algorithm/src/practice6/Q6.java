package practice6;

import java.util.Scanner;

public class Q6 {
    static void swap(int[] a, int before, int after) {
        int temp = a[before];
        a[before] = a[after];
        a[after] = temp;
    }

    static void ser(int[] a, int n) {
        int count = 0;
        for(int i=1; i<n; i++) {
            for(int j=i; j>0; j--) {
                if (a[j] < a[j-1]) {
                    swap(a, j-1, j);
                } else {
                    break;
                }
                count++;
            }
        }
        System.out.println(count);
    }

    static void ser1(int[] a, int n) {
        int count = 0;
        for(int i=1; i<n; i++) {
            int j;
            int temp = a[i];
            for(j=i; j>0 && a[j-1] > temp; j--) {
                a[j] = a[j-1];
                count++;
            }
            a[j] = temp;
        }
        System.out.println(count);
    }

    public static void result() {
        Scanner scan = new Scanner(System.in);

//        System.out.print("요솟수 : ");
//        int n = scan.nextInt();
//        int[] a = new int[n];
//
//        for(int i=0; i<n; i++) {
//            System.out.print("숫자 입력 : ");
//            a[i] = scan.nextInt();
//        }
        int n = 7;
        int[] a = {6, 4, 1, 7, 3, 9, 8};

        ser1(a, n);

        for(int i=0; i<n; i++) {
            System.out.printf("%2d", a[i]);
        }
    }
}
