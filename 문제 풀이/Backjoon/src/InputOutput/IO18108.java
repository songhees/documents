package InputOutput;

import java.io.IOException;
import java.util.Scanner;

public class IO18108 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int data;
        do {
            data = scan.nextInt();
        } while (data < 1000 || 3000 < data);
        System.out.println(data-543);
    }
}
