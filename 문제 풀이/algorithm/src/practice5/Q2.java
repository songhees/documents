package practice5;

import java.util.Scanner;

public class Q2 {

    static int gcd(int x, int y) {
        while(y > 0) {
            int a = x;
            x = y;
            y = a%y;
        }
        return x;
    }

    public static void result() {
        Scanner scan = new Scanner(System.in);
        int x, y;
            System.out.print("x숫자입력 : ");
            x = scan.nextInt();
            System.out.print("y숫자입력 : ");
            y = scan.nextInt();
        System.out.printf("최대공약수 : %d", gcd(x, y));
    }
}
