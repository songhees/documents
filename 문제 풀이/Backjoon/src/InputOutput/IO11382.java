package InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO11382 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        long result = 0;

        for (String ar : arr) {
            result += Long.parseLong(ar);
        }
        System.out.print(result);
    }
}
