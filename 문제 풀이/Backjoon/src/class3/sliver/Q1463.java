package class3.sliver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 */
public class Q1463 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = read();

        int[] array = new int[num+1];

        array[1] = 0;
        for(int i=2; i<num+1; i++) {
            int min = i;

            if (i%2 == 0) {
                min = Math.min(array[i/2]+1, min);
            }

            if (i%3 == 0) {
                min = Math.min(array[i/3]+1, min);
            }

            min = Math.min(array[i-1]+1, min);
            array[i] = min;
        }
        bw.write(String.valueOf(array[num]));
        bw.flush();
        bw.close();
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
