package class2;

import java.io.*;

public class Q1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String data = br.readLine();
            if ("0".equals(data)) {
                break;
            }

            bw.write(isPal(data));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static String isPal(String data) {
        int left = 0;
        int right = data.length()-1;

        while(left < right) {
            if (data.charAt(left) == data.charAt(right)) {
                left++;
                right--;
            } else {
                return "no";
            }
        }
        return "yes";
    }
}
