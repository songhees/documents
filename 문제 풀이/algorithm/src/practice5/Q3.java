package practice5;

import java.util.Scanner;

public class Q3 {

    static int gcdArray(int[] a, int start, int num) {
        if (num == 1) {
            return a[start];
        } else {
            return Q2.gcd(a[start], gcdArray(a, start+1, num-1));
        }

    }

    public static void result() {
        Scanner scan = new Scanner(System.in);
        System.out.print("배열 개수입력 : ");
        int[] a = new int[scan.nextInt()];

        for(int i=0; i< a.length; i++) {
            System.out.print("입력할 숫자 : ");
            a[i] = scan.nextInt();
        }

        System.out.printf("최대공약수 : %d", gcdArray(a, 0, a.length));
    }
}
