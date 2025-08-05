package practice3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 내림차순 검색
 */
public class Q7 {

    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " "  + height + " " + vision;
        }

        public static final Comparator<PhyscData> HEIGHTORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {

            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return (o1.vision > o2.vision) ? -1 : ((o1.vision < o2.vision) ? 1 : 0);
            }
        }
    }

    public static void result() {
        Scanner stdIn = new Scanner(System.in);
        PhyscData[] x = {					// 배열 요소는 시력 오름차순으로 정렬
                new PhyscData("박준서", 175, 2.0),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("황지안", 169, 0.8),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("강민하", 162, 0.3),
        };
        System.out.print("검색할 시력은?  : ");
        double vision = stdIn.nextDouble();			   // 키값을 입력받음

        int index = Arrays.binarySearch(x, new PhyscData("", 0, vision), PhyscData.HEIGHTORDER);

        if (index < 0) {
            System.out.println("해당하는 정보가 없습니다.");
        } else {
            System.out.println("찾은 데이터 : " + x[index]);
        }
    }
}