package practice2;

import java.util.Scanner;

public class Q7 {

    public static void process() {
        Scanner scan = new Scanner(System.in);

        System.out.println("10진수를 기수 변환합니다.");

        int target;
        do {
            System.out.printf("변환하는 음이 아닌 정수 : ");
            target = scan.nextInt();
        } while(target < 0);


        int su;
        do {
            System.out.printf("어떤 진수로 변환할까요? : ");
            su = scan.nextInt();
        } while(su < 0 && su > 36);

        System.out.printf("%d진수로 %s입니다.", su, result(target, su));
    }

    private static String result(int target, int su) {
        int n = ((Integer)target).toString().length();
        String num = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] result = new char[36];
        int index = 0;

        System.out.printf(String.format("%%2d | %%%dd\n", n), su, target);
        do {
            System.out.println(" +--------");
            result[index] = num.charAt(target%su); // 나머지

            target /= su; // 몫

            if (target != 0)
                System.out.printf(String.format("%%2d | %%%dd    ... %%c\n", n),
                        su, target, result[index++] );
            else
                System.out.printf(String.format("     %%%dd    ... %%c\n", n),
                        target, result[index++]);
        } while (target != 0);

        String s = "";
        for(int i = 0; i< index; i++) {
            s += result[index-i-1];
        }

        return s;
    }
}
