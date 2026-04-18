package implementation.bronze;

import java.io.*;

public class Q10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<26; i++) {
            sb.append(word.indexOf(i+97)).append(" ");
        }
        System.out.print(sb.toString());
    }
}
