package practice1;

import java.util.Scanner;

public class Q11 {

    /**
     * 양의 숫자 자리구하기
     */
    public static void result() {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        String num = String.valueOf(a);
        System.out.printf("그 수는 %d자리입니다.", num.length());
    }

    public static void result1() {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();

        System.out.println((a / 10));

        int no = 0;         // 자릿수
        while (a > 0) {
            a /= 10;         // n을 10으로 나눕니다
            no++;
        }

        System.out.printf("그 수는 %d자리입니다.", no);
    }
}
