import practice2.Q11;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Q11 ymd = new Q11(2025, 11, 12);
        Q11 result = ymd.after(60);
        System.out.printf("%d년 %d월 %d일", result.y, result.m, result.d);
    }
}