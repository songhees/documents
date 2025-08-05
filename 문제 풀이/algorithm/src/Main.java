import practice07.IntSet;
import practice5.*;
import practice6.*;
import practice6.Q1;
import practice6.Q3;
import practice6.Q5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IntSet result = new IntSet(5);

        result.add(4);
        result.add(3);
        result.add(4);
        result.add(6);
        result.add(7);

        System.out.println(result.toString());
        // 4, 3, 5, 6

        IntSet gyo = new IntSet(4);
        gyo.add(4);
        gyo.add(7);
        gyo.add(3);
        gyo.add(6);

        System.out.println(result.isProperSubsetOf(gyo)); // 4, 3, 6
    }
}