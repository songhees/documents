package practice6;

import java.util.Scanner;
import java.util.Stack;

public class Q11 {
    static void swap(int[] a, int before, int after) {
        int temp = a[before];
        a[before] = a[after];
        a[after] = temp;
    }

    static void insertSort(int[] a, int left, int right) {
        for (int i = left+1; i <= right; i++) {
            int temp = a[i];
            int target = i;
            for(int j = i-1; j >= 0 && a[j] > temp; j--) {
                a[target] = a[j];
                a[j] = temp;
                target = j;
            }

        }
    }
    static void quickSort(int[] a, int left, int right) {
        Stack<Integer> lstack = new Stack();
        Stack<Integer> rstack = new Stack();

        lstack.push(left);
        rstack.push(right);

        while(!lstack.isEmpty()) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(left + right)/2];

            do {
                while(a[pl] < x) pl++;
                while(a[pr] > x) pr--;

                if (pl <= pr) {
                    swap(a, pl++, pr--);
                }
            } while (pl <= pr);

            if (pr - left < right - pl) {
                int temp;
                temp = left;  left  = pl; pl = temp;
                temp = right; right = pr; pr = temp;
            }
            if (pr - left <= 9) {
                insertSort(a, left, pr);
            } else if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
            }
            if (right - pl <= 9) {
                insertSort(a, pl, right);
            } else if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
            }

        }

    }

    public static void result() {
        Scanner scan = new Scanner(System.in);

//        System.out.print("요솟수 : ");
//        int n = scan.nextInt();
//        int[] a = new int[n];
//
//        for(int i=0; i<n; i++) {
//            System.out.print("숫자 입력 : ");
//            a[i] = scan.nextInt();
//        }
        int n = 9;
        int[] a = {5,7,1,4,6,2,3,9,8};

        quickSort(a, 0, n-1);

        for(int i=0; i<n; i++) {
            System.out.printf("%2d", a[i]);
        }
    }
}
