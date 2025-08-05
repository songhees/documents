package practice6;

import java.util.Scanner;

public class Q8 {
    static void swap(int[] a, int before, int after) {
        int temp = a[before];
        a[before] = a[after];
        a[after] = temp;
    }

    static void ser1(int[] a, int n) {
        int count = 0;
        for(int i=1; i<n; i++) {

            int temp = a[i];
            int pl = 0;
            int pr = i-1;
            int index = 0;
            int pc = 0;
            while (pl <= pr) {
                pc = (pr + pl) / 2;
                if (a[pc] == temp) {
                    break;
                } else if (a[pc] > temp) {
                    pr = pc-1;
                } else {
                    pl = pc+1;
                }
            }
            index = (pl <= pr) ? pc + 1 : pr + 1;

            for(int j=i; j>index; j--) {
                a[j] = a[j-1];
            }
            a[index] = temp;
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
