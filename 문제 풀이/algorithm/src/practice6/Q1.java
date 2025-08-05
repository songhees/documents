package practice6;

import java.util.Scanner;

/**
 * 버블 정렬
 */
public class Q1 {
    /**
     * index = 0 부터 시작해서 끝에 가장 큰 값이 옮겨지는 정렬
     */
    static void bubbleSort(int[] a, int n) {
        // 첫 for문은 교환되어야될 요소의 개수
        for(int i=0; i<n-1; i++) {
            // 교환이 이뤄지는 횟수
            for(int j=0; j<n-1; j++) {
                if (a[j] > a[j+1]) {
                    swap(a, j, j+1);
                }
            }
        }
    }

    static void swap(int[] a, int before, int after) {
        int temp = a[before];
        a[before] = a[after];
        a[after] = temp;
    }

    public static void result() {
        Scanner scan = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int n = scan.nextInt();
        int[] a = new int[n];

        for(int i=0; i<n; i++) {
            System.out.print("숫자 입력 : ");
            a[i] = scan.nextInt();
        }

        bubbleSort(a, n);

        for(int i=0; i<n; i++) {
            System.out.printf("%2d", a[i]);
        }
    }
}
