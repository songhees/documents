package class3.gold;

import java.io.IOException;

public class Q14500 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = read();
        for (int i=0; i<T; i++) {

        }
        System.out.println(sb);
    }



    static int read() throws IOException {
        int num = System.in.read() & 15;
        int input;
        while ((input = System.in.read()) > 32) {
            num = (num << 3) + (num << 1) + (input & 15);
        }
        return num;
    }
}
