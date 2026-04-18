package implementation.bronze;

import java.io.*;

public class Q1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int count = 0;
        int newNum = num;
        while (true) {
            int value = (newNum/10) + (newNum%10);
            newNum = newNum%10*10 + value%10;
            count++;

            if (newNum == num) {
                break;
            }
        }
        System.out.print(count);
    }
}
