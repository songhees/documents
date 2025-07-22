package practice2;

import java.util.Scanner;

public class Q8 {

    public static void result() {
        Scanner scan = new Scanner(System.in);

        System.out.print("년: ");
        int year = scan.nextInt();
        System.out.print("월: ");
        int month = scan.nextInt();
        System.out.print("일: ");
        int day = scan.nextInt();

        System.out.printf("그 해 %d일째입니다.", dayOfYears(year, month, day));

    }

    static int[][] mdays = {
            {31,28,31,30,31,30,31,31,30,31,30,31}, // 평년 // 365
            {31,29,31,30,31,30,31,31,30,31,30,31}  // 윤년 // 366
    };

    /**
     * 평년 or 윤년 여부 계산 method
     * @param year
     * @return
     */
    static int isLeap(int year) {
        return (year %4==0 && year%100 !=0 || year % 400 == 0) ? 1 : 0;
    }

    static int dayOfYears(int y, int m, int d) {
        while(m>1) {
            d += mdays[isLeap(y)][--m];
        }
        return d;
    }
}
