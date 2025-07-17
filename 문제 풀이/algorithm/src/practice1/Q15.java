package practice1;

import java.util.Scanner;

public class Q15 {
    static Scanner scan = new Scanner(System.in);
    /**
     * 왼쪽 위가 직각 이등변 삼각형
     */
    public static void result() {
        int n = scan.nextInt();

        for(int i = 0; i < n ; i++) {
            for(int j = n-i; j > 0 ;j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 오른쪽 위가 직각 이등변 삼각형
     */
    public static void result1() {
        int n = scan.nextInt();

//        for(int i = 0; i < n ; i++) {
//            for(int j = 0; j < n ;j++) {
//                if (j < i) {
//                    System.out.print(" ");
//                } else {
//                    System.out.print("*");
//                }
//            }
//            System.out.println();
//        }


        for(int i = 1; i <= n ; i++) {
            for(int j = 1; j < i ;j++) {
                System.out.print(" ");
            }
            for(int j = n; j >= i ;j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 오른쪽 아래가 직각 이등변 삼각형
     */
    public static void result2() {
        int n = scan.nextInt();

//        for(int i = 1; i <= n ; i++) {
//            for(int j = n; j > 0 ;j--) {
//                if (j > i) {
//                    System.out.print(" ");
//                } else {
//                    System.out.print("*");
//                }
//            }
//            System.out.println();
//        }

        for(int i = 1; i <= n ; i++) {
            for(int j = 1; j <= n-i ;j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= i ;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
