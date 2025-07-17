package practice1;

import java.util.Scanner;

public class Q10 {
    public static void result() {
        Scanner scn = new Scanner(System.in);

        int a = scn.nextInt();
        System.out.printf("a의 값  %d\n", a);
        int b;
        while(true) {
            b = scn.nextInt();
            System.out.printf("b의 값  %d\n", b);
            if (a < b) break;
            System.out.println("a보다 큰 값을 입력하세요!");
        }

        System.out.printf("b-a는 %d입니다.", (b-a));
    }
}
