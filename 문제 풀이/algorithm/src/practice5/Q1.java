package practice5;

import java.util.Scanner;

public class Q1 {

    static int factorial(int n) {
        if (n>0) {
            int result = 1;
            for (int i=n; i>=1; i--) {
                result *= i;
            }
            return result;
        } else
            return 1;
    }

    public static void result() {
        Scanner scan = new Scanner(System.in);

        System.out.print("숫자입력 : ");
        int n = scan.nextInt();

        System.out.printf("결과값 : %d", factorial(n));
    }
}
