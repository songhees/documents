package practice1;

import java.util.Scanner;

public class Q16 {

    public static void result() {
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= (2*i-1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
