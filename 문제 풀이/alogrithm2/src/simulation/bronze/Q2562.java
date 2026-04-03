package simulation.bronze;

import java.io.*;

public class Q2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int index = 0;

        for (int i=0; i<9; i++) {
            int target = Integer.parseInt(br.readLine());

            if (max < target) {
                index = i+1;
                max = target;
            }
        }
        System.out.print(max + "\n" + index);
    }
}
