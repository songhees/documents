package practice5;

import practice4.Gstack;

import java.util.Scanner;

public class Q5 {

    static void recur(int n) {
        if (n > 0) {
            recur(n-1);
            recur(n-2);
            System.out.print(n);
        }
    }
    // 1
    //2
    //1
    //3
    //1
    //2
    //4

    /**
     * 비재귀적 구현
     * @param n
     */
    static void recur1(int n) {
        Gstack<Integer> stack = new Gstack<>(n);

        while (true) {
            if (n > 0) {
                stack.push(n);
                n = n - 1;
                continue;
            }

            if (stack.isEmpty() != true) {
                n = stack.pop();
                System.out.print(n);
                n = n - 1;
                continue;
            }
        }
    }


    public static void result() {
        Scanner scan = new Scanner(System.in);

        System.out.print("n : ");
        int n = scan.nextInt();

        recur1(n);
    }
}
